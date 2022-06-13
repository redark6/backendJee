package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrievePaginatedRecipes implements Query {
    public final String productName;

    public RetrievePaginatedRecipes(String productName) {
        this.productName = productName;
    }
}
