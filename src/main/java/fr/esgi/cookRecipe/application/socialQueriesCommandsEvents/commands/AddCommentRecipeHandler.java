package fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.social.entity.Comment;
import fr.esgi.cookRecipe.domain.social.service.CommentService;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import kernel.CommandHandler;

import java.util.Date;
import java.util.UUID;

public class AddCommentRecipeHandler implements CommandHandler<AddCommentRecipe, Void> {

    private final UserAccountService userAccountService;
    private final CommentService commentService;
    private final RecipeService recipeService;

    public AddCommentRecipeHandler(UserAccountService userAccountService, CommentService commentService, RecipeService recipeService) {
        this.userAccountService = userAccountService;
        this.commentService = commentService;
        this.recipeService = recipeService;
    }

    public Void handle(AddCommentRecipe command) {
        UserAccount user = this.userAccountService.getMyUserAccount();
        Recipe recipe = this.recipeService.getRecipeById(UUID.fromString(command.addCommentRecipeDTO.recipeId));
        Comment comment = new Comment();
        comment.setBody(command.addCommentRecipeDTO.Comment);
        comment.setPostedDate(new Date());
        comment.setRecipe(recipe);
        comment.setUser(user);
        this.commentService.addComment(comment);
        return null;
    }
}
