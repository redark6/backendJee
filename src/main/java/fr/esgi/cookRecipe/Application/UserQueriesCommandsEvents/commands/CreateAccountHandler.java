package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.UserDTO.CreateAccountDTO;
import kernel.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

public class CreateAccountHandler implements CommandHandler<CreateAccount, Void> {

	private final UserAccountService userAccountService;

	@Autowired
	public CreateAccountHandler(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

    public Void handle(CreateAccount command) {
		CreateAccountDTO dto = command.createAccountDTO;;
		List<GrantedAuthority> grntdAuths = List.of(new SimpleGrantedAuthority("USER"));

		UserAccount userAccount = new UserAccount();
		userAccount.setId(null);
		userAccount.setUsername(dto.userName);
		userAccount.setEmail(dto.email);
		userAccount.setInscriptionDate(new Date());
		this.userAccountService.createUser(userAccount,dto.email,dto.password,grntdAuths);
    	return null;
    }
}
