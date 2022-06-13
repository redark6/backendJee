package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.events;

import kernel.ApplicationEvent;

public class CreateAccountEvent implements ApplicationEvent {
	
	public final String username;
	
    public static CreateAccountEvent of(String username) {
        return new CreateAccountEvent(username);
    }
	
	private CreateAccountEvent(String username) {
		this.username = username;
	}
}
