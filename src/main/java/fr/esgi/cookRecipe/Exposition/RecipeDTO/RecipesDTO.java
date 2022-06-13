package fr.esgi.cookRecipe.Exposition.RecipeDTO;

import java.util.List;

public class RecipesDTO {
    public final List<RecipeDTO> recipes;

    private RecipesDTO(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }

    public static RecipesDTO of(List<RecipeDTO> recipes) {
        return new RecipesDTO(recipes);
    }

}
