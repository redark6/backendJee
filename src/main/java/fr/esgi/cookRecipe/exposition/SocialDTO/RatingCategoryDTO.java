package fr.esgi.cookRecipe.exposition.SocialDTO;

public class RatingCategoryDTO {

    private String id;
    private String name;

    public static RatingCategoryDTO of(String id, String name) {
        return new RatingCategoryDTO(id, name);
    }

    private RatingCategoryDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RatingCategory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
