package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RetrieveRecipesByProductNameHandler implements QueryHandler<RetrieveRecipesByProductName, RecipesDTO> {

	private final RecipeService recipeService;

	public RetrieveRecipesByProductNameHandler(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Override
	public RecipesDTO handle(RetrieveRecipesByProductName query) {
		Pageable pageRequest = PageRequest.of(query.offset, query.limit);
		// call service custome to deduce name
		List<Recipe> recipes = this.recipeService.getRecipesByProductName(query.productName,pageRequest);
		return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
	}
}
