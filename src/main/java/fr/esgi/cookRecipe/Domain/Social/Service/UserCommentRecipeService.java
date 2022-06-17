package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Social.Entity.UserCommentsRecipe;
import fr.esgi.cookRecipe.Domain.Social.Repository.UserCommentRecipeRepository;

import java.util.UUID;

public class UserCommentRecipeService {
    private final UserCommentRecipeRepository userCommentRecipeRepository;

    public UserCommentRecipeService(UserCommentRecipeRepository userCommentRecipeRepository) {
        this.userCommentRecipeRepository = userCommentRecipeRepository;
    }

    public void addCommentRecipe(UserCommentsRecipe userCommentsRecipe) {
        this.saveCommentRecipe(userCommentsRecipe);
    }

    public void removeCommentRecipeByCommentId(UUID commentId) {
        this.userCommentRecipeRepository.deleteUserCommentsRecipeByComment_id(commentId);
    }

    public Long getUserNumberComment(UUID userId) {
        return this.userCommentRecipeRepository.countUserCommentsRecipeByUser_id(userId);
    }

    private void saveCommentRecipe(UserCommentsRecipe userCommentsRecipe) {
        this.userCommentRecipeRepository.save(userCommentsRecipe);
    }
}
