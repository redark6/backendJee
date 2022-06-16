package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import kernel.Command;

public class LikeRecipe  implements Command {

    public final String recipeId;

    public LikeRecipe(String recipeId) {
        this.recipeId = recipeId;
    }
}
