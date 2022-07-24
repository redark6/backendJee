package fr.esgi.cookRecipe.domain.social.repository;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.social.entity.Like;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
    Optional<Like> findLikeByRecipeAndUser(Recipe recipe, UserAccount user);
    long countByRecipeAndLikedTrue(Recipe recipe);
}
