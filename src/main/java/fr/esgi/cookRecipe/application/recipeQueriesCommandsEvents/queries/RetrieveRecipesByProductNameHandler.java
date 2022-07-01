package fr.esgi.cookRecipe.application.recipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.recipe.service.RecipeService;
import fr.esgi.cookRecipe.exposition.RecipeDTO.RecipesDTO;
import fr.esgi.cookRecipe.external.service.ProductApiService;
import kernel.QueryHandler;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RetrieveRecipesByProductNameHandler implements QueryHandler<RetrieveRecipesByProductName, RecipesDTO> {

	private final RecipeService recipeService;
	private final ProductApiService productApiService;

	public RetrieveRecipesByProductNameHandler(RecipeService recipeService, ProductApiService productApiService) {
		this.recipeService = recipeService;
		this.productApiService = productApiService;
	}

	@Override
	public RecipesDTO handle(RetrieveRecipesByProductName query) {
		Pageable pageRequest = PageRequest.of(query.offset, query.limit);
		String nameFound = query.autocomplete ? this.productApiService.getSearchAutocomplete(query.productName) : query.productName;
		List<Recipe> recipes = this.recipeService.getRecipesByProductName(nameFound,pageRequest);
		return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
	}
}
