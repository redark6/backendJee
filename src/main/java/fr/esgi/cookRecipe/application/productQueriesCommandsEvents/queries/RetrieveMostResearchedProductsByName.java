package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveMostResearchedProductsByName implements Query {
    public final String productName;
    public final int limit;
    public final int offset;
    public final boolean autocomplete;

    public RetrieveMostResearchedProductsByName(String productName, int limit, int offset, boolean autocomplete) {
        this.productName = productName;
        this.limit = limit;
        this.offset = offset;
        this.autocomplete = autocomplete;
    }
}
