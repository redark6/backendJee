package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import java.util.List;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.NutriScore;
import fr.esgi.cookRecipe.domain.product.service.NutriScoreService;
import fr.esgi.cookRecipe.exposition.ProductDTO.NutriScoresDTO;
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
