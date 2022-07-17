package fr.esgi.cookRecipe.exposition.UserDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ModifyMailDTO {

    @NotBlank
    @Email
    public String newMail;
}
