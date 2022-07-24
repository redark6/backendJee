package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveUserById implements Query {
	public final String userId;
	
    public RetrieveUserById(String userId) {
        this.userId = userId;
    }
}