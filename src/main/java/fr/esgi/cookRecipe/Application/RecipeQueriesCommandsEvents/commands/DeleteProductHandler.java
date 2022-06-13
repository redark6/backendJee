package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Product.Service.ProductService;
import kernel.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class DeleteProductHandler implements CommandHandler<DeleteProductById, Void> {

    private final ProductService productService;

    @Autowired
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
