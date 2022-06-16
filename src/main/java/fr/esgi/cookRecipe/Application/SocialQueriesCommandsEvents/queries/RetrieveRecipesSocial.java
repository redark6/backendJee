package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesSocial implements Query {

    public final String recipeId;

    public RetrieveRecipesSocial(String recipeId) {
        this.recipeId = recipeId;
    }
}
