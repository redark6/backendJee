package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands;

import kernel.Command;

public class DeleteProductById implements Command {
    public final String productId;

    public DeleteProductById(String productId) {
        this.productId = productId;
    }
}
