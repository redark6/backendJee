package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipeById implements Query{
    public final String recipeId;
    public final String research;

    public RetrieveRecipeById(String recipeId, String research) {
        this.recipeId = recipeId;
        this.research = research;
    }
}
