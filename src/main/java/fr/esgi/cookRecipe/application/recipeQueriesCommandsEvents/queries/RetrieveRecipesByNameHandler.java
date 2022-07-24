package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import fr.esgi.cookRecipe.external.service.RecipeApiService;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RetrieveRecipesByNameHandler implements QueryHandler<RetrieveRecipesByName, RecipesDTO>{

    private final RecipeService recipeService;
    private final RecipeApiService recipeApiService;

    public RetrieveRecipesByNameHandler(RecipeService recipeService, RecipeApiService recipeApiService) {
        this.recipeService = recipeService;
        this.recipeApiService = recipeApiService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByName query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        String nameFound = query.autocomplete ? this.recipeApiService.getSearchAutocomplete(query.name) : query.name;
        List<Recipe> recipes = this.recipeService.getRecipesByName(nameFound, pageRequest);
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}
