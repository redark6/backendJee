package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Social.Service.CommentService;
import fr.esgi.cookRecipe.Domain.Social.Service.UserCommentRecipeService;
import kernel.CommandHandler;

import java.util.UUID;

public class DeleteCommentRecipeHandler implements CommandHandler<DeleteCommentRecipe, Void> {

    private final CommentService commentService;
    private final UserCommentRecipeService userCommentRecipeService;

    public DeleteCommentRecipeHandler(CommentService commentService, UserCommentRecipeService userCommentRecipeService) {
        this.commentService = commentService;
        this.userCommentRecipeService = userCommentRecipeService;
    }

    public Void handle(DeleteCommentRecipe command) {
        UUID commentId = UUID.fromString(command.commentId);
        this.commentService.commentExist(commentId);
        this.userCommentRecipeService.removeCommentRecipeByCommentId(commentId);
        this.commentService.removeCommentById(commentId);
        return null;
    }
}
