package fr.esgi.cookRecipe.exposition.SocialDTO;

public class CommentDTO {

    public String id;
    public String comment;
    public boolean isUserComment;
    public String authorId;
    public String authorUserName;
    public String postedDate;

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
