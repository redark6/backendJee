package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public class RetrieveRecipesByProductIdHandler implements QueryHandler<RetrieveRecipesByProductId, RecipesDTO> {

    private final RecipeService recipeService;

    public RetrieveRecipesByProductIdHandler(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public RecipesDTO handle(RetrieveRecipesByProductId query) {
        Pageable pageRequest = PageRequest.of(query.offset, query.limit);
        List<Recipe> recipes = this.recipeService.getRecipesByProductId(UUID.fromString(query.productId), pageRequest);
        return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
    }
}
