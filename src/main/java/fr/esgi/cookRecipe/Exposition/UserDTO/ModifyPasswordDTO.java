package fr.esgi.cookRecipe.Exposition.UserDTO;

import javax.validation.constraints.NotBlank;

public class ModifyPasswordDTO {

    @NotBlank
    public String newPassword;
}
