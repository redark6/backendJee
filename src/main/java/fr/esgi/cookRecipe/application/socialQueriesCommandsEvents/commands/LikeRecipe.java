package fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands;

import kernel.Command;

public class LikeRecipe  implements Command {

    public final String recipeId;
    public final boolean liked;

    public LikeRecipe(String recipeId, boolean liked) {
        this.recipeId = recipeId;
        this.liked = liked;
    }
}
