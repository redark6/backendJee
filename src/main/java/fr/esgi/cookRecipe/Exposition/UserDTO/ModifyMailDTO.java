package fr.esgi.cookRecipe.Exposition.UserDTO;

import javax.validation.constraints.NotBlank;

public class ModifyMailDTO {

    @NotBlank
    public String newMail;
}
