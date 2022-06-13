package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.UserDTO.UserMeDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;


public class RetrieveUserMeHandler implements QueryHandler<RetrieveUserMe, UserMeDTO> {

	private final UserAccountService userAccountService;

	@Autowired
	public RetrieveUserMeHandler(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	@Override
	public UserMeDTO handle(RetrieveUserMe query) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		UserAccount userAccount = userAccountService.getUserAccountByEmail(email);
		return UserMeDTO.of(userAccount.getId().toString(),userAccount.getUsername(), userAccount.getEmail(),userAccount.getRecipies().size(),5,userAccount.getInscriptionDate().toString());
	}
}