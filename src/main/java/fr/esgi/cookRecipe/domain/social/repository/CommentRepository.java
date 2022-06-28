package fr.esgi.cookRecipe.domain.social.repository;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.social.entity.Comment;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> getAllByRecipe(Recipe recipe);
    int countCommentsByUser(UserAccount user);
}
