package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesByProductId implements Query {
    public final int limit;
    public final int offset;

    public RetrieveRecipesByProductId(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }
}