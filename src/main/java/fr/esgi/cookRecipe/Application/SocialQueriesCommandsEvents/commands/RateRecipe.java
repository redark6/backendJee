package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.SocialDTO.RateRecipeDTO;
import kernel.Command;

public class RateRecipe  implements Command {

    public final RateRecipeDTO rateRecipeDTO;

    public RateRecipe(RateRecipeDTO rateRecipeDTO) {
        this.rateRecipeDTO = rateRecipeDTO;
    }

}
