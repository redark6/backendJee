package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipeById implements Query{
    public final String recipeId;
    public final String research;

    public RetrieveRecipeById(String recipeId, String research) {
        this.recipeId = recipeId;
        this.research = research;
    }
}
