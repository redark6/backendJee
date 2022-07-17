package fr.esgi.cookRecipe.exposition.RecipeDTO;

import fr.esgi.cookRecipe.exposition.ProductDTO.NutriScoreDTO;

public class RecipeProductDTO {
    public String id;
    public String name;
    public int quantity;
    public String unite;
    public NutriScoreDTO nutriScore;

    public static RecipeProductDTO of(String id, String name, int quantity, String unite, NutriScoreDTO nutriScore) {
        return new RecipeProductDTO(id, name, quantity, unite, nutriScore);
    }

    private RecipeProductDTO(String id, String name, int quantity, String unite, NutriScoreDTO nutriScore) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.unite = unite;
        this.nutriScore = nutriScore;
    }
}
