package fr.esgi.cookRecipe.Exposition.RecipeDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class RecipeProductQuantityDTO {

    @NotBlank
    public String productId;

    @NotEmpty
    @Min(value = 1)
    public int quantity;
}
