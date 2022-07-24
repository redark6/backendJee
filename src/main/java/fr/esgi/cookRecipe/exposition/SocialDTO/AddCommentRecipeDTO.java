package fr.esgi.cookRecipe.exposition.SocialDTO;

import javax.validation.constraints.NotBlank;

public class AddCommentRecipeDTO {

    @NotBlank
    public String recipeId;

    @NotBlank
    public String Comment;
}
