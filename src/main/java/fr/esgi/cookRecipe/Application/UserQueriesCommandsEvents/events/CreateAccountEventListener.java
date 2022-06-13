package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.events;

import kernel.EventListener;

public class CreateAccountEventListener implements EventListener<CreateAccountEvent> {
	
    @Override
    public void listenTo(CreateAccountEvent event) {
        System.out.println("listening CreateAccountEvent.");
    }

}
