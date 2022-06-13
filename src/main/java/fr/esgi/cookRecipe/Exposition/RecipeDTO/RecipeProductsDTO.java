package fr.esgi.cookRecipe.Exposition.RecipeDTO;

import java.util.List;

public class RecipeProductsDTO {
    public final List<RecipeProductDTO> products;

    public static RecipeProductsDTO of(List<RecipeProductDTO> products) {
        return new RecipeProductsDTO(products);
    }

    private RecipeProductsDTO(List<RecipeProductDTO> products) {
        this.products = products;
    }
}
