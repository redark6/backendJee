package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.util.entity.ProductLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.exposition.ProductDTO.ProductsDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveNeverResearchedProductsByNameHandler implements QueryHandler<RetrieveNeverResearchedProductsByName, ProductsDTO> {
    private final LogService logService;

    public RetrieveNeverResearchedProductsByNameHandler(LogService logService) {
        this.logService = logService;
    }

    @Override
    public ProductsDTO handle(RetrieveNeverResearchedProductsByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        // service pour deduire le name
        List<ProductLog> productLogs = this.logService.getNeverResearchedProductLogByName(query.productName,pageRequest);
        List<Product> products = productLogs.stream().map(p -> p.getProduct()).collect(Collectors.toList());
        return EntityToDTOSerializer.productsToProductsDTO(products);
    }
}
