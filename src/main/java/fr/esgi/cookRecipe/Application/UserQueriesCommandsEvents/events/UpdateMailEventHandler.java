package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.events;

import kernel.EventListener;

public class UpdateMailEventHandler implements EventListener<UpdateMailEvent>  {

    @Override
    public void listenTo(UpdateMailEvent event) {
        System.out.println("listening UpdateMailEvent.");
    }
}
