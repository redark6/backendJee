package fr.esgi.cookRecipe.exposition.ProductDTO;

import java.util.List;

public class NutriScoresDTO {

    public final List<NutriScoreDTO> nutriScores;

    public static NutriScoresDTO of(List<NutriScoreDTO> nutriScores) {
        return new NutriScoresDTO(nutriScores);
    }

    private NutriScoresDTO(List<NutriScoreDTO> nutriScores) {
        this.nutriScores = nutriScores;
    }
}
