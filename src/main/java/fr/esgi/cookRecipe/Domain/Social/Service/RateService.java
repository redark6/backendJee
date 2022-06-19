package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Social.Entity.UserRatesRecipe;
import fr.esgi.cookRecipe.Domain.Social.Repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RateService {
    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public void putRate(UserRatesRecipe userRatesRecipe){
        this.saveRate(userRatesRecipe);
    }

    /*
    public Long getRecipeLikeScore(UUID recipeId){
        return this.rateRepository.countByRecipeIdAndLikedTrue(recipeId);
    }
*/
    public Optional<UserRatesRecipe> findUserRateScore(UUID recipeId, String userId){
        return this.rateRepository.findUserRatesRecipeByRecipeIdAndUserId(recipeId, userId);
    }

    private void saveRate(UserRatesRecipe userRatesRecipe) {
        this.rateRepository.save(userRatesRecipe);
    }
}
