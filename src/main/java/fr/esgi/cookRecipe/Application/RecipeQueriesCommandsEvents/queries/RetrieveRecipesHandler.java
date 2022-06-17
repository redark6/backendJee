package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
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