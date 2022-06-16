package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesByProductName implements Query{
    public final String productName;
    public final int limit;
    public final int offset;

    public RetrieveRecipesByProductName(String productName, int limit, int offset) {
        this.productName = productName;
        this.limit = limit;
        this.offset = offset;
    }
}
