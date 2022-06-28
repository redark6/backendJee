package fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.exposition.SocialDTO.AddCommentRecipeDTO;
import kernel.Command;

public class AddCommentRecipe  implements Command {

    public final AddCommentRecipeDTO addCommentRecipeDTO;

    public AddCommentRecipe(AddCommentRecipeDTO addCommentRecipeDTO) {
        this.addCommentRecipeDTO = addCommentRecipeDTO;
    }
}
