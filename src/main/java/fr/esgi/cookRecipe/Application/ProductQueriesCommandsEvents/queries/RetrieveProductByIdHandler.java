package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Domain.Util.Entity.ProductLog;
import fr.esgi.cookRecipe.Domain.Util.Entity.RecipeLog;
import fr.esgi.cookRecipe.Domain.Util.Entity.ResearchLog;
import fr.esgi.cookRecipe.Domain.Util.Service.LogService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import kernel.QueryHandler;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RetrieveProductByIdHandler implements QueryHandler<RetrieveProductById, ProductDTO>{

    private final ProductService productService;
    private final LogService logService;
    private final UserAccountService userAccountService;

    public RetrieveProductByIdHandler(ProductService productService, LogService logService, UserAccountService userAccountService) {
        this.productService = productService;
        this.logService = logService;
        this.userAccountService = userAccountService;
    }

    @Override
    public ProductDTO handle(RetrieveProductById query) {
        UUID productId = UUID.fromString(query.productId);
        Product product = productService.getProductById(productId);

        ProductLog productLog = this.logService.getProductLogByProduct(product);
        List<ResearchLog> researchLogList = productLog.getResearches();
        ResearchLog researchLog = new ResearchLog();
        researchLog.setUser(this.userAccountService.getMyUserAccount());
        researchLog.setEntitled(query.research);
        researchLog.setExecutionDate(new Date());
        researchLogList.add(researchLog);
        productLog.setResearches(researchLogList);
        productLog.setCount(productLog.getCount() + 1);
        this.logService.saveProductLog(productLog);

        return EntityToDTOSerializer.productToProductDTO(product);
    }
}
