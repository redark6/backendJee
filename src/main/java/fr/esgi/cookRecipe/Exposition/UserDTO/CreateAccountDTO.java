package fr.esgi.cookRecipe.Exposition.UserDTO;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class CreateAccountDTO {

    @Email
    @NotBlank
    public String email;

    @Size(min = 5, max = 50)
    @NotBlank
    public String userName;

    @Size(min = 8, max = 32)
    @NotBlank
    public String password;

}
