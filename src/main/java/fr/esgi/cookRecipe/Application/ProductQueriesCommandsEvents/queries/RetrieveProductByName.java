package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveProductByName implements Query {
    public final String productName;

    public RetrieveProductByName(String productName) {
        this.productName = productName;
    }
}
