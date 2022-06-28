package fr.esgi.cookRecipe.exposition.ProductDTO;

public class NutriScoreDTO {

    private String id;
    private char grade;

    public static NutriScoreDTO of(String id, char grade) {
        return new NutriScoreDTO(id, grade);
    }

    private NutriScoreDTO(String id, char grade) {
        this.id = id;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "NutriScoreDTO{" +
                "id=" + id +
                ", grade='" + grade +
                '}';
    }
}
