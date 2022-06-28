package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveNeverResearchedRecipesByName implements Query {
    public final String name;
    public final int limit;
    public final int offset;

    public RetrieveNeverResearchedRecipesByName(String name, int limit, int offset) {
        this.name = name;
        this.limit = limit;
        this.offset = offset;
    }
}
