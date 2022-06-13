package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.events;

import kernel.ApplicationEvent;

public class UpdateMailEvent implements ApplicationEvent {

    public final String email;

    public static UpdateMailEvent of(String email) {
        return new UpdateMailEvent(email);
    }

    private UpdateMailEvent(String email) {
        this.email = email;
    }
}
