package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveMostResearchedRecipesByName implements Query {
    public final String name;
    public final int limit;
    public final int offset;

    public RetrieveMostResearchedRecipesByName(String name, int limit, int offset) {
        this.name = name;
        this.limit = limit;
        this.offset = offset;
    }
}
