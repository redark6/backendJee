package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.social.service.CommentService;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import fr.esgi.cookRecipe.exposition.UserDTO.UserMeDTO;
import kernel.QueryHandler;
import org.springframework.security.core.context.SecurityContextHolder;


public class RetrieveUserMeHandler implements QueryHandler<RetrieveUserMe, UserMeDTO> {

	private final UserAccountService userAccountService;
	private final RecipeService recipeService;
	private final CommentService commentService;

	public RetrieveUserMeHandler(UserAccountService userAccountService, RecipeService recipeService, CommentService commentService) {
		this.userAccountService = userAccountService;
		this.recipeService = recipeService;
		this.commentService = commentService;
	}

	@Override
	public UserMeDTO handle(RetrieveUserMe query) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		UserAccount userAccount = userAccountService.getUserAccountByEmail(email);
		int nbRecipe = recipeService.getUserRecipeCount(userAccount);
		int nbComment = commentService.getUserCommentCount(userAccount);
		return EntityToDTOSerializer.userToUserMeDTO(userAccount,nbRecipe,nbComment);
	}
}
