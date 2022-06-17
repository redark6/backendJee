package fr.esgi.cookRecipe.Application.ProductQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
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