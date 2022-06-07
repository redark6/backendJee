package fr.esgi.cookRecipe.Exposition.ProductDTO;

import javax.validation.constraints.NotBlank;

public class AddProductDTO {

    @NotBlank
    public String name;
    @NotBlank
    public String uniteId;
    @NotBlank
    public String nutriScoreId;
}
