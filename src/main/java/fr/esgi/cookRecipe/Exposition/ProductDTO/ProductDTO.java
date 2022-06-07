package fr.esgi.cookRecipe.Exposition.ProductDTO;

import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;

public class ProductDTO {
    private String id;
    private String name;
    private String unite;
    private NutriScoreDTO nutriScore;

    public static ProductDTO of(String id, String name, String unite, NutriScoreDTO nutriScore) {
        return new ProductDTO(id, name, unite, nutriScore);
    }

    private ProductDTO(String id, String name, String unite, NutriScoreDTO nutriScore) {
        this.id = id;
        this.name = name;
        this.unite = unite;
        this.nutriScore = nutriScore;
    }

    @Override
    public String toString() {
        return "NutriScoreDTO{" +
                "id=" + id + "\n" +
                ", name=" + name + "\n" +
                ", unite=" + unite + "\n" +
                ", nutriScore='" + nutriScore.toString() +
                '}';
    }
}
