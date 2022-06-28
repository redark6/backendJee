package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveNeverResearchedProductsByName implements Query {
    public final String productName;
    public final int limit;
    public final int offset;

    public RetrieveNeverResearchedProductsByName(String productName, int limit, int offset) {
        this.productName = productName;
        this.limit = limit;
        this.offset = offset;
    }
}
