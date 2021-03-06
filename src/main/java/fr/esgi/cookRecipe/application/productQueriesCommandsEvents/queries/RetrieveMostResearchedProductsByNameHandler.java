package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.util.entity.ProductLog;
import fr.esgi.cookRecipe.domain.util.service.LogService;
import fr.esgi.cookRecipe.exposition.ProductDTO.ProductsDTO;
import fr.esgi.cookRecipe.external.service.ProductApiService;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveMostResearchedProductsByNameHandler implements QueryHandler<RetrieveMostResearchedProductsByName, ProductsDTO> {
    private final LogService logService;
    private final ProductApiService productApiService;

    public RetrieveMostResearchedProductsByNameHandler(LogService logService, ProductApiService productApiService) {
        this.logService = logService;
        this.productApiService = productApiService;
    }

    @Override
    public ProductsDTO handle(RetrieveMostResearchedProductsByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        String nameFound = query.autocomplete ? this.productApiService.getSearchAutocomplete(query.productName) : query.productName;
        List<ProductLog> productLogs = this.logService.getMostResearchedProductLogByName(nameFound,pageRequest);
        List<Product> products = productLogs.stream().map(p -> p.getProduct()).collect(Collectors.toList());
        return EntityToDTOSerializer.productsToProductsDTO(products);
    }
}
