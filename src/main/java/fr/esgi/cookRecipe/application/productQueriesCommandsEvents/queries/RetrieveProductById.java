package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveProductById implements Query {
	public final String productId;
	public final String research;

    public RetrieveProductById(String productId, String research) {
        this.productId = productId;
        this.research = research;
    }
}
