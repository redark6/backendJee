package fr.esgi.cookRecipe.Exposition.SocialDTO;

public class RecipeSocialDTO {

    private CommentsDTO comments;
    private LikeDTO like;
    private RatingsUserDTO ratings;

    public static RecipeSocialDTO of(CommentsDTO comments, LikeDTO like, RatingsUserDTO ratings) {
        return new RecipeSocialDTO(comments, like, ratings);
    }

    private RecipeSocialDTO(CommentsDTO comments, LikeDTO like, RatingsUserDTO ratings) {
        this.comments = comments;
        this.like = like;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "RecipesSocialDTO{" +
                "comments=" + comments +
                ", like=" + like +
                ", ratings=" + ratings +
                '}';
    }
}
