package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.exposition.UserDTO.CreateAccountDTO;
import kernel.Command;

public class CreateAccount implements Command {

	public final CreateAccountDTO createAccountDTO;
	
	public CreateAccount(CreateAccountDTO createAccountDTO) {
		this.createAccountDTO = createAccountDTO;
	}
	
}
