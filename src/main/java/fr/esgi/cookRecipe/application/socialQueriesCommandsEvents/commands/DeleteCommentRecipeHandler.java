package fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.social.service.CommentService;
import kernel.CommandHandler;

import java.util.UUID;

public class DeleteCommentRecipeHandler implements CommandHandler<DeleteCommentRecipe, Void> {

    private final CommentService commentService;

    public DeleteCommentRecipeHandler(CommentService commentService) {
        this.commentService = commentService;
    }

    public Void handle(DeleteCommentRecipe command) {
        UUID commentId = UUID.fromString(command.commentId);
        this.commentService.removeCommentById(commentId);
        return null;
    }
}
