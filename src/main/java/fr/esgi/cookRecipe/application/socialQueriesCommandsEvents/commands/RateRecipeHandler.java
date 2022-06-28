package fr.esgi.cookRecipe.application.socialQueriesCommandsEvents.commands;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.domain.social.entity.Category;
import fr.esgi.cookRecipe.domain.social.entity.Rate;
import fr.esgi.cookRecipe.domain.social.service.CategoryService;
import fr.esgi.cookRecipe.domain.social.service.RateService;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import fr.esgi.cookRecipe.domain.user.service.UserAccountService;
import kernel.CommandHandler;

import java.util.Optional;
import java.util.UUID;

public class RateRecipeHandler implements CommandHandler<RateRecipe, Void> {

    private final RateService rateService;
    private final CategoryService categoryService;
    private final RecipeService recipeService;
    private final UserAccountService userAccountService;

    public RateRecipeHandler(RateService rateService, CategoryService categoryService, RecipeService recipeService, UserAccountService userAccountService) {
        this.rateService = rateService;
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.userAccountService = userAccountService;
    }

    public Void handle(RateRecipe command) {
        UserAccount user = this.userAccountService.getMyUserAccount();
        Recipe recipe = this.recipeService.getRecipeById(UUID.fromString(command.rateRecipeDTO.recipeId));
        Category category = this.categoryService.getCategoryById(UUID.fromString(command.rateRecipeDTO.categoryId));
        Optional<Rate> UserRatesRecipeMaybe = this.rateService.findUserRecipeCategoryRateScore(user, recipe, category);
        Rate userRatesRecipe;
        if(UserRatesRecipeMaybe.isPresent()){
            userRatesRecipe = UserRatesRecipeMaybe.get();
        }else{
            userRatesRecipe = new Rate();
            userRatesRecipe.setUser(user);
            userRatesRecipe.setRecipe(recipe);
            userRatesRecipe.setCategory(category);
        }
        userRatesRecipe.setRate(command.rateRecipeDTO.rateValue);

        this.rateService.putRate(userRatesRecipe);
        return null;
    }
}
