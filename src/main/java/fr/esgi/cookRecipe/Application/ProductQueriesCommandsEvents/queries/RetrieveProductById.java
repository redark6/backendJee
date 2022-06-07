package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveProductById implements Query {
	public final String productId;
	
    public RetrieveProductById(String productId) {
        this.productId = productId;
    }
}