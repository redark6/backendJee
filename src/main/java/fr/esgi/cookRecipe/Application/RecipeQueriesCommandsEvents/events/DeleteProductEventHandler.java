package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.events;

import kernel.EventListener;

public class DeleteProductEventHandler implements EventListener<DeleteProductEvent>  {

    @Override
    public void listenTo(DeleteProductEvent event) {
        System.out.println("listening DeleteProductEvent.");
    }
}
