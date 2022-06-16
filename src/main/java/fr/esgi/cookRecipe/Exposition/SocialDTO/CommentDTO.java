package fr.esgi.cookRecipe.Exposition.SocialDTO;

public class CommentDTO {

    private String id;
    private String comment;
    private boolean isUserComment;
    private String authorId;
    private String authorUserName;
    private String postedDate;

    public static CommentDTO of(String id, String comment, boolean isUserComment, String authorId, String authorUserName, String postedDate) {
        return new CommentDTO(id, comment, isUserComment,authorId,authorUserName, postedDate);
    }

    private CommentDTO(String id, String comment, boolean isUserComment,String authorId, String authorUserName, String postedDate) {
        this.id = id;
        this.comment = comment;
        this.isUserComment = isUserComment;
        this.authorId = authorId;
        this.authorUserName = authorUserName;
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                ", isUserComment=" + isUserComment +
                ", authorId='" + authorId + '\'' +
                ", authorUserName='" + authorUserName + '\'' +
                ", postedDate='" + postedDate + '\'' +
                '}';
    }
}
