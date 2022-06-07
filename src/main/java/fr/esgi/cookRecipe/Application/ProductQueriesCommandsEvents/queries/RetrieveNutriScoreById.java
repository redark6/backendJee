package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveNutriScoreById implements Query {
	public final String nutriScoreId;
	
    public RetrieveNutriScoreById(String nutriScoreId) {
        this.nutriScoreId = nutriScoreId;
    }
}