package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.events;

import kernel.EventListener;

public class UpdatePasswordEventHandler implements EventListener<UpdatePasswordEvent> {

    @Override
    public void listenTo(UpdatePasswordEvent event) {
        System.out.println("listening UpdatePasswordEvent.");
    }
}
