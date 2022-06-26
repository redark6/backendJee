package fr.esgi.cookRecipe.Application.UserQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Service.CommentService;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import fr.esgi.cookRecipe.Exposition.UserDTO.UserDTO;
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