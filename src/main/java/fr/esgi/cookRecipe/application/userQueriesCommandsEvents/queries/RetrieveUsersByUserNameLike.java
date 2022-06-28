package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.queries;

import kernel.Query;

public class RetrieveUsersByUserNameLike implements Query {
    public final String usernamelike;
    public final int limit;
    public final int offset;

    public RetrieveUsersByUserNameLike(String usernamelike, int limit, int offset) {
        this.usernamelike = usernamelike;
        this.limit = limit;
        this.offset = offset;
    }
}