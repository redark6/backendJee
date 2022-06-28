package fr.esgi.cookRecipe.exposition.UserDTO;

public class UserListItemDTO {

    private String id;
    private String username;
    private String inscriptionDate;

    public static UserListItemDTO of(String id, String username, String inscriptionDate) {
        return new UserListItemDTO(id, username, inscriptionDate);
    }

    private UserListItemDTO(String id, String username, String inscriptionDate) {
        this.id = id;
        this.username = username;
        this.inscriptionDate = inscriptionDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", inscriptionDate='" + inscriptionDate + '\'' +
                '}';
    }
}
