package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrievePaginatedProducts implements Query {
    public final int limit;
    public final int offset;

    public RetrievePaginatedProducts(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }
}