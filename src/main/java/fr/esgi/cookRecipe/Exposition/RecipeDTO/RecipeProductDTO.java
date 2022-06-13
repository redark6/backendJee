package fr.esgi.cookRecipe.Exposition.RecipeDTO;

import fr.esgi.cookRecipe.Exposition.ProductDTO.NutriScoreDTO;

public class RecipeProductDTO {
    private String id;
    private String name;
    private int quantity;
    private String unite;
    private NutriScoreDTO nutriScore;

    public static RecipeProductDTO of(String id, String name, String unite, int quantity, NutriScoreDTO nutriScore) {
        return new RecipeProductDTO(id, name, unite, quantity, nutriScore);
    }

    private RecipeProductDTO(String id, String name, String unite, int quantity, NutriScoreDTO nutriScore) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.unite = unite;
        this.nutriScore = nutriScore;
    }
}