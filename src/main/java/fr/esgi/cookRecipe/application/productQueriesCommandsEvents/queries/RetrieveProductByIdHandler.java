package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import fr.esgi.cookRecipe.domain.util.entity.ProductLog;
import fr.esgi.cookRecipe.domain.util.entity.ResearchLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.exposition.ProductDTO.ProductDTO;
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
