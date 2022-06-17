package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.ProductDTO;
import kernel.QueryHandler;

import java.util.UUID;

public class RetrieveProductByIdHandler implements QueryHandler<RetrieveProductById, ProductDTO>{

    private final ProductService productService;

    public RetrieveProductByIdHandler(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDTO handle(RetrieveProductById query) {
        UUID productId = UUID.fromString(query.productId);
        Product product = productService.getProductById(productId);
        return EntityToDTOSerializer.productToProductDTO(product);
    }
}