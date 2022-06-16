package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipeById implements Query{
    public final String recipeId;

    public RetrieveRecipeById(String recipeId) {
        this.recipeId = recipeId;
    }
}
