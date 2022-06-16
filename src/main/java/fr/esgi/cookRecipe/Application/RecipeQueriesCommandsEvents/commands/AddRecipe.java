package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.RecipeDTO.AddRecipeDTO;
import fr.esgi.cookRecipe.Exposition.UserDTO.CreateAccountDTO;
import kernel.Command;

public class AddRecipe implements Command {

	public final AddRecipeDTO addRecipeDTO;
	
	public AddRecipe(AddRecipeDTO addRecipeDTO) {
		this.addRecipeDTO = addRecipeDTO;
	}
	
}
