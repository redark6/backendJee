package fr.esgi.cookRecipe.Exposition.SocialDTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class RateRecipeDTO {

    @NotBlank
    public String recipeId;

    @NotBlank
    public String categoryId;

    @NotEmpty
    @Min(value = 0L)
    @Max(value = 5L)
    public int rateValue;

}
