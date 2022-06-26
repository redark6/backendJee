package fr.esgi.cookRecipe.Exposition.SocialDTO;

public class RatingUserDTO {

    private RatingDTO rating;
    private boolean userRated;
    private double userRating;

    public static RatingUserDTO of(RatingDTO rating, boolean userRated, int userRating) {
        return new RatingUserDTO(rating, userRated, userRating);
    }

    private RatingUserDTO(RatingDTO rating, boolean userRated, int userRating) {
        this.rating = rating;
        this.userRated = userRated;
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "RatingsUserDTO{" +
                "rating=" + rating +
                ", userRated=" + userRated +
                ", userRating=" + userRating +
                '}';
    }
}
