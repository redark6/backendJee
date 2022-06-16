package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Recipe.Service.RecipeService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductDTO;
import fr.esgi.cookRecipe.Exposition.RecipeDTO.RecipeProductsDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.stream.Collectors;

public class RetrieveRecipeByIdHandler implements QueryHandler<RetrieveRecipeById, RecipeDTO> {

	private final RecipeService recipeService;

	@Autowired
	public RetrieveRecipeByIdHandler(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Override
	public RecipeDTO handle(RetrieveRecipeById query) {
		UUID recipeId = UUID.fromString(query.recipeId);
		Recipe recipe = recipeService.getRecipeById(recipeId);

		return RecipeDTO.of(
				recipe.getId().toString(),
				recipe.getName(),
				recipe.getShares(),
				recipe.getExecutionTime(),
				recipe.getPrice(),
				RecipeProductsDTO.of(
						recipe.getProducts().stream().map(product ->
								RecipeProductDTO.of(
										product.getProduct().getId().toString(),
										product.getProduct().getName(),
										product.getQuantity(),
										product.getProduct().getMesure().getUnit(),
										NutriScoreDTO.of(product.getProduct().getNutriScore().getId().toString(), product.getProduct().getNutriScore().getGrade())
								)
						).collect(Collectors.toList())
				)
		);
	}
}
