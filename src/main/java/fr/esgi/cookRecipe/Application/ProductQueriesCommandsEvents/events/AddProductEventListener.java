package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.events;

import kernel.EventListener;

public class AddProductEventListener implements EventListener<AddProductEvent> {
	
    @Override
    public void listenTo(AddProductEvent event) {
        System.out.println("listening AddNutriScoreEvent.");
    }

}
