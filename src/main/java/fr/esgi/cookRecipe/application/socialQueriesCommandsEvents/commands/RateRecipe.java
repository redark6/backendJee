package fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.exposition.SocialDTO.RateRecipeDTO;
import kernel.Command;

public class RateRecipe  implements Command {

    public final RateRecipeDTO rateRecipeDTO;

    public RateRecipe(RateRecipeDTO rateRecipeDTO) {
        this.rateRecipeDTO = rateRecipeDTO;
    }

}
