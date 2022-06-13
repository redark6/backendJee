package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Exposition.UserDTO.CreateAccountDTO;
import kernel.Command;

public class CreateAccount implements Command {

	public final CreateAccountDTO createAccountDTO;
	
	public CreateAccount(CreateAccountDTO createAccountDTO) {
		this.createAccountDTO = createAccountDTO;
	}
	
}
