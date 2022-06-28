package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import fr.esgi.cookRecipe.exposition.UserDTO.CreateAccountDTO;
import kernel.CommandHandler;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

public class CreateAccountHandler implements CommandHandler<CreateAccount, Void> {

	private final UserAccountService userAccountService;

	public CreateAccountHandler(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	@Override
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
