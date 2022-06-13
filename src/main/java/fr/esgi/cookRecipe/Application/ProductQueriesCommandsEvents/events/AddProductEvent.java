package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.events;

import kernel.ApplicationEvent;

public class AddProductEvent implements ApplicationEvent {
	
	public final String name;
	
    public static AddProductEvent of(String name) {
        return new AddProductEvent(name);
    }
	
	private AddProductEvent(String name) {
		this.name = name;
	}
}
