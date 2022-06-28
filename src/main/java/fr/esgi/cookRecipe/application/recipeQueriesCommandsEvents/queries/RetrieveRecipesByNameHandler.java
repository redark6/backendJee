package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RetrieveRecipesByNameHandler implements QueryHandler<RetrieveRecipesByName, RecipesDTO>{

    private final RecipeService recipeService;

    public RetrieveRecipesByNameHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        // call service custome to deduce name
        List<Recipe> recipes = this.recipeService.getRecipesByName(query.name, pageRequest);
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}