package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import kernel.QueryHandler;

import java.util.UUID;

public class RetrieveRecipeByIdHandler implements QueryHandler<RetrieveRecipeById, RecipeDTO> {

	private final RecipeService recipeService;

	public RetrieveRecipeByIdHandler(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Override
	public RecipeDTO handle(RetrieveRecipeById query) {
		UUID recipeId = UUID.fromString(query.recipeId);
		Recipe recipe = recipeService.getRecipeById(recipeId);
		return EntityToDTOSerializer.recipeToRecipeDTO(recipe);
	}
}
