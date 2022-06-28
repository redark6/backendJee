package fr.esgi.cookRecipe.exposition.UserDTO;

import javax.validation.constraints.NotBlank;

public class ModifyMailDTO {

    @NotBlank
    public String newMail;
}
