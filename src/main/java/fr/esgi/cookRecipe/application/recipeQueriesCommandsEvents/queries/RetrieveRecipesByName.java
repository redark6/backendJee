package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveRecipesByName implements Query {
	public final String name;
	public final int limit;
	public final int offset;
	public final boolean autocomplete;

    public RetrieveRecipesByName(String name, int limit, int offset, boolean autocomplete) {
        this.name = name;
        this.limit = limit;
        this.offset = offset;
        this.autocomplete = autocomplete;
    }
}
