package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveNutriScoreById implements Query {
	public final String nutriScoreId;
	
    public RetrieveNutriScoreById(String nutriScoreId) {
        this.nutriScoreId = nutriScoreId;
    }
}