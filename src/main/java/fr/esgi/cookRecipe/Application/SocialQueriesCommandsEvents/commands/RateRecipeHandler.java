package fr.esgi.cookRecipe.Application.SocialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Domain.Social.Entity.UserRatesRecipe;
import fr.esgi.cookRecipe.Domain.Social.Service.CategoryService;
import fr.esgi.cookRecipe.Domain.Social.Service.RateService;
import kernel.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public class RateRecipeHandler implements CommandHandler<RateRecipe, Void> {

    private final RateService rateService;
    private final CategoryService categoryService;
    private final RecipeService recipeService;

    @Autowired
    public RateRecipeHandler(RateService rateService, CategoryService categoryService, RecipeService recipeService) {
        this.rateService = rateService;
        this.categoryService = categoryService;
        this.recipeService = recipeService;
    }

    public Void handle(RateRecipe command) {
        UUID recipeId = UUID.fromString(command.rateRecipeDTO.recipeId);
        UUID categoryId = UUID.fromString(command.rateRecipeDTO.categoryId);
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        double rate = command.rateRecipeDTO.rateValue;
        this.recipeService.recipeExist(recipeId);
        this.categoryService.recipeExist(recipeId);

        Optional<UserRatesRecipe> UserRatesRecipeMaybe = this.rateService.findUserRateLike(recipeId,userId);
        UserRatesRecipe userRatesRecipe;
        if(UserRatesRecipeMaybe.isPresent()){
            userRatesRecipe = UserRatesRecipeMaybe.get();
        }else{
            userRatesRecipe = new UserRatesRecipe();
            userRatesRecipe.setId(UUID.randomUUID());
            userRatesRecipe.setRecipeId(recipeId);
            userRatesRecipe.setUserId(userId);
            userRatesRecipe.setCategoryId(categoryId);
        }
        userRatesRecipe.setRate(rate);

        this.rateService.putRate(userRatesRecipe);
        return null;
    }
}
