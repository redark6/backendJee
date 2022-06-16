package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import kernel.Command;

public class UnlikeRecipe implements Command {

    public final String recipeId;

    public UnlikeRecipe(String recipeId) {
        this.recipeId = recipeId;
    }
}
