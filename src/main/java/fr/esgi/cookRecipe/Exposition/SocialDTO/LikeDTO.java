package fr.esgi.cookRecipe.Exposition.SocialDTO;

public class LikeDTO {

    private double likeRate;
    private boolean userLiked;
    private double userLikingRate;

    public static LikeDTO of(double likeRate, boolean userLiked, double userLikingRate) {
        return new LikeDTO(likeRate, userLiked, userLikingRate);
    }

    private LikeDTO(double likeRate, boolean userLiked, double userLikingRate) {
        this.likeRate = likeRate;
        this.userLiked = userLiked;
        this.userLikingRate = userLikingRate;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "likeRate=" + likeRate +
                ", userLiked=" + userLiked +
                ", userLikingRate=" + userLikingRate +
                '}';
    }
}
