package fr.esgi.cookRecipe.exposition.SocialDTO;

public class RatingDTO {

    public double rate;
    public RatingCategoryDTO ratingCategory;

    public static RatingDTO of(double rate, RatingCategoryDTO ratingCategory) {
        return new RatingDTO(rate, ratingCategory);
    }

    private RatingDTO(double rate, RatingCategoryDTO ratingCategory) {
        this.rate = rate;
        this.ratingCategory = ratingCategory;
    }

    @Override
    public String toString() {
        return "RatingDTO{" +
                "rate=" + rate +
                ", ratingCategory=" + ratingCategory +
                '}';
    }
}
