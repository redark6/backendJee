package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveRecipesByProductIdHandler implements QueryHandler<RetrieveRecipesByProductId, RecipesDTO> {

    private final RecipeService recipeService;

    public RetrieveRecipesByProductIdHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByProductId query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        List<Recipe> recipes = this.recipeService.getRecipesByName(query.productId); // -> create query for product id
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}
