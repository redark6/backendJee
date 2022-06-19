package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Social.Entity.Comment;
import fr.esgi.cookRecipe.Domain.Social.Entity.UserCommentsRecipe;
import fr.esgi.cookRecipe.Domain.Social.Service.CommentService;
import fr.esgi.cookRecipe.Domain.Social.Service.UserCommentRecipeService;
import kernel.CommandHandler;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.UUID;

public class AddCommentRecipeHandler implements CommandHandler<AddCommentRecipe, Void> {

    private final CommentService commentService;
    private final UserCommentRecipeService userCommentRecipeService;

    public AddCommentRecipeHandler(CommentService commentService, UserCommentRecipeService userCommentRecipeService) {
        this.commentService = commentService;
        this.userCommentRecipeService = userCommentRecipeService;
    }

    public Void handle(AddCommentRecipe command) {
        UUID commentId = UUID.randomUUID();
        Comment comment = new Comment();
        comment.setId(commentId);
        comment.setBody(command.addCommentRecipeDTO.Comment);
        comment.setPostedDate(new Date());
        UserCommentsRecipe userCommentsRecipe = new UserCommentsRecipe();
        userCommentsRecipe.setId(UUID.randomUUID());
        userCommentsRecipe.setCommentId(commentId);
        userCommentsRecipe.setRecipeId(commentId);
        userCommentsRecipe.setUserId(SecurityContextHolder.getContext().getAuthentication().getName());
        this.commentService.addComment(comment);
        this.userCommentRecipeService.addCommentRecipe(userCommentsRecipe);
        return null;
    }
}
