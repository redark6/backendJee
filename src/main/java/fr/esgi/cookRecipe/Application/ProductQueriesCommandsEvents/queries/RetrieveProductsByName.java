package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveProductsByName implements Query {
    public final String productName;
    public final int limit;
    public final int offset;

    public RetrieveProductsByName(String productName, int limit, int offset) {
        this.productName = productName;
        this.limit = limit;
        this.offset = offset;
    }
}