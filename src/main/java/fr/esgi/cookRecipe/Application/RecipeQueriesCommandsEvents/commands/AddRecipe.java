package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.UserDTO.CreateAccountDTO;
import kernel.Command;

public class AddRecipe implements Command {

	public final CreateAccountDTO createAccountDTO;
	
	public AddRecipe(CreateAccountDTO createAccountDTO) {
		this.createAccountDTO = createAccountDTO;
	}
	
}
