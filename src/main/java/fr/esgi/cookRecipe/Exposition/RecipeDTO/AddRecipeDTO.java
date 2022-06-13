package fr.esgi.cookRecipe.Exposition.RecipeDTO;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.RecipeProductQuantity;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class AddRecipeDTO {

    @NotBlank
    public String name;

    @NotBlank
    private int shares;

    @NotBlank
    private Long executionTime;

    @NotBlank
    private double price;

    @NotBlank
    private List<RecipeProductQuantity> products;
}
