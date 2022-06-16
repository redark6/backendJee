package fr.esgi.cookRecipe.Domain.Social.Repository;

import fr.esgi.cookRecipe.Domain.Social.Entity.UserCommentsRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCommentRecipeRepository extends JpaRepository<UserCommentsRecipe, UUID> {
    void deleteUserCommentsRecipeByComment_id(UUID commentId);
    long countUserCommentsRecipeByUser_id(UUID commentId);
}
