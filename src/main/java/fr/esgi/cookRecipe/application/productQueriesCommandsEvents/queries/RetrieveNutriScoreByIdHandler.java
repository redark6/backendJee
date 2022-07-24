package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.product.entity.NutriScore;
import fr.esgi.cookRecipe.domain.product.service.NutriScoreService;
import fr.esgi.cookRecipe.exposition.ProductDTO.NutriScoreDTO;
import kernel.QueryHandler;

import java.util.UUID;

public class RetrieveNutriScoreByIdHandler implements QueryHandler<RetrieveNutriScoreById, NutriScoreDTO>{

    private final NutriScoreService nutriScoreService;

    public RetrieveNutriScoreByIdHandler(NutriScoreService nutriScoreService) {
        this.nutriScoreService = nutriScoreService;
    }

    @Override
    public NutriScoreDTO handle(RetrieveNutriScoreById query) {
    	UUID nutriScoreId = UUID.fromString(query.nutriScoreId);
    	NutriScore nutriScore = nutriScoreService.getNutrisScoreById(nutriScoreId);
        return EntityToDTOSerializer.nutriscoreToNutriScoreDTO(nutriScore);
    }
}