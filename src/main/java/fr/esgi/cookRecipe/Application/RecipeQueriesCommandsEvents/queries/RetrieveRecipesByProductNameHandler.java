package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipesDTO;
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
		List<Recipe> recipes = this.recipeService.getRecipesByName(query.productName);  // -> create query for product name
		return EntityToDTOSerializer.recipeToRecipeDTO(recipes);
	}
}
