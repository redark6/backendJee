package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductsDTO;
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