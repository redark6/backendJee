package fr.esgi.cookRecipe.exposition.UserDTO;

import javax.validation.constraints.NotBlank;

public class ModifyPasswordDTO {

    @NotBlank
    public String newPassword;
}
