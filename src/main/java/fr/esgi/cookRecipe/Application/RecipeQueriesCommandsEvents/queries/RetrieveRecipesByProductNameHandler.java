package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoresDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveRecipesByProductNameHandler implements QueryHandler<RetrieveRecipesByProductName, NutriScoresDTO> {

	private final NutriScoreService nutriScoreService;

	@Autowired
	public RetrieveRecipesByProductNameHandler(NutriScoreService nutriScoreService) {
		this.nutriScoreService = nutriScoreService;
	}

	@Override
	public NutriScoresDTO handle(RetrieveRecipesByProductName query) {
		List<NutriScore> nutriScores = nutriScoreService.getAllNutriScores();

		NutriScoresDTO result = NutriScoresDTO.of(nutriScores.stream()
				.map(nutriScore ->
						NutriScoreDTO.of(
								nutriScore.getId().toString(),
								nutriScore.getGrade()
						)
				).collect(Collectors.toList()));
		return result;
	}
}
