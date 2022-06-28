package fr.esgi.cookRecipe.domain.social.service;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.social.entity.Category;
import fr.esgi.cookRecipe.domain.social.entity.Rate;
import fr.esgi.cookRecipe.domain.social.repository.RateRepository;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
