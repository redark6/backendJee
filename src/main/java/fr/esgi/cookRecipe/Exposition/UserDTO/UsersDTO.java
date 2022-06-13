package fr.esgi.cookRecipe.Exposition.UserDTO;


import java.util.List;

public class UsersDTO {

    public final List<UserDTO> users;

    public static UsersDTO of(List<UserDTO> users) {
        return new UsersDTO(users);
    }

    private UsersDTO(List<UserDTO> users) {
        this.users = users;
    }
}
