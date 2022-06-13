package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesByName implements Query {
	public final String userId;
	
    public RetrieveRecipesByName(String userId) {
        this.userId = userId;
    }
}