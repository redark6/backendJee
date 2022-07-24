package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.exposition.RecipeDTO.AddRecipeDTO;
import kernel.Command;

public class AddRecipe implements Command {

	public final AddRecipeDTO addRecipeDTO;
	
	public AddRecipe(AddRecipeDTO addRecipeDTO) {
		this.addRecipeDTO = addRecipeDTO;
	}
	
}
