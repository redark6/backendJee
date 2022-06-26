package fr.esgi.cookRecipe.Domain.Social.Repository;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Social.Entity.Like;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
    Optional<Like> findLikeByRecipeAndUser(Recipe recipe, UserAccount user);
    long countByRecipeAndLikedTrue(Recipe recipe);
}
