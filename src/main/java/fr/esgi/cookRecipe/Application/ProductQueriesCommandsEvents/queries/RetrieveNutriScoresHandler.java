package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import java.util.List;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoresDTO;
import kernel.QueryHandler;

public class RetrieveNutriScoresHandler implements QueryHandler<RetrieveNutriScores, NutriScoresDTO> {

	private final NutriScoreService nutriScoreService;

	public RetrieveNutriScoresHandler(NutriScoreService nutriScoreService) {
		this.nutriScoreService = nutriScoreService;
	}

	@Override
	public NutriScoresDTO handle(RetrieveNutriScores query) {
		List<NutriScore> nutriScores = nutriScoreService.getAllNutriScores();
		return EntityToDTOSerializer.nutriscoresToNutriScoresDTO(nutriScores);
	}
}
