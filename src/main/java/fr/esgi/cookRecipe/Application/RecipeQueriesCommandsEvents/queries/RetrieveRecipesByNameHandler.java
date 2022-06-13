package fr.esgi.cookRecipe.Application.RecipeQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Service.NutriScoreService;
import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;
import kernel.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RetrieveRecipesByNameHandler implements QueryHandler<RetrieveRecipesByName, NutriScoreDTO>{

    private final NutriScoreService nutriScoreService;

    @Autowired
    public RetrieveRecipesByNameHandler(NutriScoreService nutriScoreService) {
        this.nutriScoreService = nutriScoreService;
    }

    @Override
    public NutriScoreDTO handle(RetrieveRecipesByName query) {
    	UUID nutriScoreId = UUID.fromString(query.nutriScoreId);
    	NutriScore nutriScore = nutriScoreService.getNutrisScoreById(nutriScoreId);
        NutriScoreDTO result = NutriScoreDTO.of(nutriScore.getId().toString(), nutriScore.getGrade());
        return result;
    }
}