package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.events;

import kernel.ApplicationEvent;

public class AddProductEvent implements ApplicationEvent {
	
	public final char grade;
	
    public static AddProductEvent of(char grade) {
        return new AddProductEvent(grade);
    }
	
	private AddProductEvent(char grade) {
		this.grade = grade;
	}
}
