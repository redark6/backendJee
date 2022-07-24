package fr.esgi.cookRecipe.application.userQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.social.service.CommentService;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import fr.esgi.cookRecipe.exposition.UserDTO.UserDTO;
import kernel.QueryHandler;

import java.util.UUID;

public class RetrieveUserByIdHandler implements QueryHandler<RetrieveUserById, UserDTO>{

    private final UserAccountService userAccountService;
    private final RecipeService recipeService;
    private final CommentService commentService;

    public RetrieveUserByIdHandler(UserAccountService userAccountService, RecipeService recipeService, CommentService commentService) {
        this.userAccountService = userAccountService;
        this.recipeService = recipeService;
        this.commentService = commentService;
    }

    @Override
    public UserDTO handle(RetrieveUserById query) {
    	UUID userId = UUID.fromString(query.userId);
    	UserAccount userAccount = userAccountService.getUserById(userId);
    	int nbRecipe = recipeService.getUserRecipeCount(userAccount);
        int nbComment = commentService.getUserCommentCount(userAccount);
        return EntityToDTOSerializer.userToUserDTO(userAccount,nbRecipe,nbComment);
    }
}