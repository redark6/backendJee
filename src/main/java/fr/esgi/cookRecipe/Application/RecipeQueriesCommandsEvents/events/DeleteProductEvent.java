package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.events;

import kernel.ApplicationEvent;

public class DeleteProductEvent implements ApplicationEvent {

    public final String productId;

    public static DeleteProductEvent of(String productId) {
        return new DeleteProductEvent(productId);
    }

    private DeleteProductEvent(String productId) {
        this.productId = productId;
    }
}
