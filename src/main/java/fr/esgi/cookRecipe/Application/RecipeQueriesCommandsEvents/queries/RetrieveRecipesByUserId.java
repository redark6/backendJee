package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesByUserId implements Query {
    public final String userId;

    public RetrieveRecipesByUserId(String userId) {
        this.userId = userId;
    }
}
