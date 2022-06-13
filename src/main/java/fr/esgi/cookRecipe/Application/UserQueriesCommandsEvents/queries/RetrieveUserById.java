package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveUserById implements Query {
	public final String userId;
	
    public RetrieveUserById(String userId) {
        this.userId = userId;
    }
}