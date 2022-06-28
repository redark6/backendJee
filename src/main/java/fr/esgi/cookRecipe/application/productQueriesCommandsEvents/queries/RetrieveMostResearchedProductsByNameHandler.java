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

public class RetrieveMostResearchedProductsByNameHandler implements QueryHandler<RetrieveMostResearchedProductsByName, ProductsDTO> {
    private final LogService logService;

    public RetrieveMostResearchedProductsByNameHandler(LogService logService) {
        this.logService = logService;
    }

    @Override
    public ProductsDTO handle(RetrieveMostResearchedProductsByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        // service pour deduire le name
        List<ProductLog> productLogs = this.logService.getMostResearchedProductLogByName(query.productName,pageRequest);
        List<Product> products = productLogs.stream().map(p -> p.getProduct()).collect(Collectors.toList());
        return EntityToDTOSerializer.productsToProductsDTO(products);
    }
}
