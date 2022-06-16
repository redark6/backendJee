package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import kernel.Command;

public class DeleteCommentRecipe  implements Command {

    public final String commentId;

    public DeleteCommentRecipe(String commentId) {
        this.commentId = commentId;
    }
}
