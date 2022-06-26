package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Entity.Comment;
import fr.esgi.cookRecipe.Domain.Social.Service.CommentService;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import fr.esgi.cookRecipe.Domain.User.Service.UserAccountService;
import kernel.CommandHandler;
import org.springframework.security.core.context.SecurityContextHolder;

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
