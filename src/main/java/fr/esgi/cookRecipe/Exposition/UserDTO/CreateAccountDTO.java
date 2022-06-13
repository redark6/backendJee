package fr.esgi.cookRecipe.Exposition.UserDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateAccountDTO {

    @NotBlank
    @Email
    public String email;

    @NotBlank
    @Size(min = 5, max = 50)
    public String userName;

    @NotBlank
    @Size(min = 8, max = 32)
    public String password;

}
