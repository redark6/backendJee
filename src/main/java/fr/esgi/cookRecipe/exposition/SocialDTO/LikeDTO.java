package fr.esgi.cookRecipe.exposition.SocialDTO;

public class LikeDTO {

    private double likeNumber;
    private boolean userLiked;

    public static LikeDTO of(long likeNumber, boolean userLiked) {
        return new LikeDTO(likeNumber, userLiked);
    }

    private LikeDTO(long likeNumber, boolean userLiked) {
        this.likeNumber = likeNumber;
        this.userLiked = userLiked;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "likeRate=" + likeNumber +
                ", userLiked=" + userLiked +
                '}';
    }
}
