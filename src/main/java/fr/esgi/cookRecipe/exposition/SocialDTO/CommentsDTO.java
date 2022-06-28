package fr.esgi.cookRecipe.exposition.SocialDTO;

import java.util.List;

public class CommentsDTO {

    private List<CommentDTO> comments;

    public static CommentsDTO of(List<CommentDTO> comments) {
        return new CommentsDTO(comments);
    }

    private CommentsDTO(List<CommentDTO> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "comments=" + comments +
                '}';
    }
}
