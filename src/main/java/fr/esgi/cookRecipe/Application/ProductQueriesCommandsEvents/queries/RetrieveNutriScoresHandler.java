package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import java.util.List;
import java.util.stream.Collectors;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoresDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class RetrieveNutriScoresHandler implements QueryHandler<RetrieveNutriScores, NutriScoresDTO> {

	private final NutriScoreService nutriScoreService;

	@Autowired
	public RetrieveNutriScoresHandler(NutriScoreService nutriScoreService) {
		this.nutriScoreService = nutriScoreService;
	}

	@Override
	public NutriScoresDTO handle(RetrieveNutriScores query) {
		List<NutriScore> nutriScores = nutriScoreService.getAllNutriScores();

		return NutriScoresDTO.of(nutriScores.stream()
				.map(nutriScore ->
						NutriScoreDTO.of(
								nutriScore.getId().toString(),
								nutriScore.getGrade()
						)
				).collect(Collectors.toList()));
	}
}
