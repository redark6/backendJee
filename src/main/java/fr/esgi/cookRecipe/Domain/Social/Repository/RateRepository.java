package fr.esgi.cookRecipe.Domain.Social.Repository;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Social.Entity.Category;
import fr.esgi.cookRecipe.Domain.Social.Entity.Rate;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
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