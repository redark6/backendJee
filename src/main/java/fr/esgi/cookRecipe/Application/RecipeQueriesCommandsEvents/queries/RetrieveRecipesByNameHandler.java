package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
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