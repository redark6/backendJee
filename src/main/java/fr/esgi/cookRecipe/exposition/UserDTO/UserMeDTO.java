package fr.esgi.cookRecipe.exposition.UserDTO;

public class UserMeDTO {

    public String id;
    public String username;
    public String email;
    public int recipeNumber;
    public int commentNumber;
    public String inscriptionDate;

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
