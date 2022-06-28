package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.Product;
import fr.esgi.cookRecipe.domain.product.service.ProductService;
import fr.esgi.cookRecipe.exposition.ProductDTO.ProductsDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RetrieveProductsByNameHandler implements QueryHandler<RetrieveProductsByName, ProductsDTO> {

    private final ProductService productService;

    public RetrieveProductsByNameHandler(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductsDTO handle(RetrieveProductsByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        List<Product> products = productService.getProductsByName(query.productName, pageRequest);
        return EntityToDTOSerializer.productsToProductsDTO(products);
    }
}