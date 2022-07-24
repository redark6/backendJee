package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.product.service.ProductService;
import kernel.CommandHandler;

import java.util.UUID;

public class DeleteProductHandler implements CommandHandler<DeleteProductById, Void> {

    private final ProductService productService;

    public DeleteProductHandler(ProductService productService) {
        this.productService = productService;
    }
    
    @Override
    public Void handle(DeleteProductById query) {
        UUID productId = UUID.fromString(query.productId);
        this.productService.deleteProductById(productId);
        return null;
    }
}
