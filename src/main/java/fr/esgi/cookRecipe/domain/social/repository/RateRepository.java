package fr.esgi.cookRecipe.domain.social.repository;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.social.entity.Category;
import fr.esgi.cookRecipe.domain.social.entity.Rate;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RateRepository extends JpaRepository<Rate, UUID>{
    Optional<Rate> findUserRatesRecipeByUserAndRecipeAndCategory(UserAccount user, Recipe recipe, Category category);
    List<Rate> findRatesByRecipeAndCategory(Recipe recipe, Category category);
}