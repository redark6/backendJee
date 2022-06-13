package fr.esgi.cookRecipe.Exposition.UserDTO;

public class UserMeDTO {

    private String id;
    private String username;
    private String email;
    private int recipeNumber;
    private int commentNumber;
    private String inscriptionDate;

    public static UserMeDTO of(String id, String username, String email, int recipeNumber, int commentNumber, String inscriptionDate) {
        return new UserMeDTO(id, username, email, recipeNumber,commentNumber, inscriptionDate);
    }
    private UserMeDTO(String id, String username, String email, int recipeNumber, int commentNumber, String inscriptionDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.recipeNumber = recipeNumber;
        this.commentNumber = commentNumber;
        this.inscriptionDate = inscriptionDate;
    }

    @Override
    public String toString() {
        return "UserMeDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", recipeNumber=" + recipeNumber +
                ", commentNumber=" + commentNumber +
                ", inscriptionDate='" + inscriptionDate + '\'' +
                '}';
    }
}
