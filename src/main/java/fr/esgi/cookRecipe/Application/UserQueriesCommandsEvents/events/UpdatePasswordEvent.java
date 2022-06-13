package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.events;

import kernel.ApplicationEvent;

public class UpdatePasswordEvent implements ApplicationEvent {
    public static UpdatePasswordEvent of() {
        return new UpdatePasswordEvent();
    }

    private UpdatePasswordEvent() { }
}
