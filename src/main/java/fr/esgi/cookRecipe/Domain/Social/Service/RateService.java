package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Social.Entity.Category;
import fr.esgi.cookRecipe.Domain.Social.Entity.Rate;
import fr.esgi.cookRecipe.Domain.Social.Repository.RateRepository;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RateService {
    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public void putRate(Rate userRatesRecipe){
        this.saveRate(userRatesRecipe);
    }


    public List<Rate> getRecipeCategoryRates(Recipe recipe, Category category){
        return this.rateRepository.findRatesByRecipeAndCategory(recipe, category);
    }

    public Optional<Rate> findUserRecipeCategoryRateScore(UserAccount user, Recipe recipe, Category category){
        return this.rateRepository.findUserRatesRecipeByUserAndRecipeAndCategory(user, recipe, category);
    }

    private void saveRate(Rate userRatesRecipe) {
        this.rateRepository.save(userRatesRecipe);
    }
}
