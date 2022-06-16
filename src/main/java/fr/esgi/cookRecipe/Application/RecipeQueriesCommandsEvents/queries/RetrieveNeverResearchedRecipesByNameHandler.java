package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class RetrieveNeverResearchedRecipesByNameHandler implements QueryHandler<RetrieveNeverResearchedRecipesByName, RecipesDTO> {

    private final RecipeService recipeService;

    @Autowired
    public RetrieveNeverResearchedRecipesByNameHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveNeverResearchedRecipesByName query) {
        return null;
    }
}
