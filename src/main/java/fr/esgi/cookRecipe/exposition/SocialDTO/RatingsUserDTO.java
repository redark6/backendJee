package fr.esgi.cookRecipe.exposition.SocialDTO;

import java.util.List;

public class RatingsUserDTO {

    private List<RatingUserDTO> ratings;

    public static RatingsUserDTO of(List<RatingUserDTO> ratings) {
        return new RatingsUserDTO(ratings);
    }

    private RatingsUserDTO(List<RatingUserDTO> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "RatingsUserDTO{" +
                "ratings=" + ratings +
                '}';
    }
}
