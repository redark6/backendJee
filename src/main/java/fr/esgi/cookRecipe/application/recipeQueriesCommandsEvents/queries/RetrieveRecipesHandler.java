package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;

import java.util.List;

public class RetrieveRecipesHandler implements QueryHandler<RetrieveRecipes, RecipesDTO>{

    private final RecipeService recipeService;

    public RetrieveRecipesHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipes query) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}