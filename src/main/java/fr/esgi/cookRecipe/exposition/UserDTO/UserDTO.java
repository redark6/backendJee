package fr.esgi.cookRecipe.exposition.UserDTO;

public class UserDTO {

    public String id;
    public String username;
    public int recipeNumber;
    public int commentNumber;
    public String inscriptionDate;

    public static UserDTO of(String id, String username, int recipeNumber, int commentNumber, String inscriptionDate) {
        return new UserDTO(id, username, recipeNumber,commentNumber, inscriptionDate);
    }

    private UserDTO(String id, String username, int recipeNumber, int commentNumber, String inscriptionDate) {
        this.id = id;
        this.username = username;
        this.recipeNumber = recipeNumber;
        this.commentNumber = commentNumber;
        this.inscriptionDate = inscriptionDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", recipeNumber=" + recipeNumber +
                ", commentNumber=" + commentNumber +
                ", inscriptionDate='" + inscriptionDate + '\'' +
                '}';
    }
}
