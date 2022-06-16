package fr.esgi.cookRecipe.Domain.Social.Repository;

import fr.esgi.cookRecipe.Domain.Social.Entity.UserRatesRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RateRepository extends JpaRepository<UserRatesRecipe, UUID>{
    Optional<UserRatesRecipe> findUserRatesRecipeByRecipeIdAndUserId(UUID recipeId, String userId);
}