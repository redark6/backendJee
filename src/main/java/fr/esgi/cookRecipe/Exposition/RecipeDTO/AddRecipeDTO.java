package fr.esgi.cookRecipe.Exposition.RecipeDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class AddRecipeDTO {

    @NotBlank
    public String name;

    @NotEmpty
    @Min(value = 1)
    public int shares;

    @NotEmpty
    @Min(value = 1L)
    public Long executionTime;

    @NotEmpty
    @Min(value = 1L)
    public int price;

    @NotBlank
    public List<RecipeProductQuantityDTO> products;
}
