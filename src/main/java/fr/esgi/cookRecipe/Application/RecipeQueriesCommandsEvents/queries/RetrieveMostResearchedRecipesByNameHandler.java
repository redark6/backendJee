package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;

public class RetrieveMostResearchedRecipesByNameHandler implements QueryHandler<RetrieveMostResearchedRecipesByName, RecipesDTO> {

    private final RecipeService recipeService;

    public RetrieveMostResearchedRecipesByNameHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveMostResearchedRecipesByName query) {
        return null;
    }
}
