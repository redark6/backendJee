package fr.esgi.cookRecipe.exposition.UserDTO;


import java.util.List;

public class UsersDTO {

    public final List<UserListItemDTO> users;

    public static UsersDTO of(List<UserListItemDTO> users) {
        return new UsersDTO(users);
    }

    private UsersDTO(List<UserListItemDTO> users) {
        this.users = users;
    }
}
