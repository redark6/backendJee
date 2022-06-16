package fr.esgi.cookRecipe.Exposition.SocialDTO;

import javax.validation.constraints.NotBlank;

public class AddCommentRecipeDTO {

    @NotBlank
    public String recipeId;

    @NotBlank
    public String Comment;
}
