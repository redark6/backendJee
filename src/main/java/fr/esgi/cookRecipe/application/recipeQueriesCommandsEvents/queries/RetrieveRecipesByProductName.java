package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesByProductName implements Query{
    public final String productName;
    public final int limit;
    public final int offset;
    public final boolean autocomplete;

    public RetrieveRecipesByProductName(String productName, int limit, int offset, boolean autocomplete) {
        this.productName = productName;
        this.limit = limit;
        this.offset = offset;
        this.autocomplete = autocomplete;
    }
}
