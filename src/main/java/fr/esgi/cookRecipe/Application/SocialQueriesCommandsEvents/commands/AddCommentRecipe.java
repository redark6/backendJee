package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.SocialDTO.AddCommentRecipeDTO;
import kernel.Command;

public class AddCommentRecipe  implements Command {

    public final AddCommentRecipeDTO addCommentRecipeDTO;

    public AddCommentRecipe(AddCommentRecipeDTO addCommentRecipeDTO) {
        this.addCommentRecipeDTO = addCommentRecipeDTO;
    }
}
