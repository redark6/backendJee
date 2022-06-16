package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesByProductId implements Query {
    public final String productId;
    public final int limit;
    public final int offset;

    public RetrieveRecipesByProductId(String productId, int limit, int offset) {
        this.productId = productId;
        this.limit = limit;
        this.offset = offset;
    }
}