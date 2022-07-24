package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.exposition.ProductDTO.ProductsDTO;
import fr.esgi.cookRecipe.external.service.ProductApiService;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RetrieveProductsByNameHandler implements QueryHandler<RetrieveProductsByName, ProductsDTO> {

    private final ProductService productService;
    private final ProductApiService productApiService;

    public RetrieveProductsByNameHandler(ProductService productService, ProductApiService productApiService) {
        this.productService = productService;
        this.productApiService = productApiService;
    }

    @Override
    public ProductsDTO handle(RetrieveProductsByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        String nameFound = query.autocomplete ? this.productApiService.getSearchAutocomplete(query.productName) : query.productName;
        List<Product> products = productService.getProductsByName(nameFound, pageRequest);
        return EntityToDTOSerializer.productsToProductsDTO(products);
    }
}
