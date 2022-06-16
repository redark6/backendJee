package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Social.Repository.CommentRepository;
import fr.esgi.cookRecipe.Domain.Social.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentById(UUID id) throws Exception {
        Optional<Comment> comment = this.commentRepository.findById(id);
        if(comment.isEmpty()){
            throw new Exception("");
        }
        return comment.get();
    }

    public List<Comment> getCommentsByRecipe(UUID recipeId) {
        this.commentRepository.
    }

    public void addComment(Comment comment) {
        this.saveComment(comment);
    }

    public void removeCommentById(UUID id) {
        this.commentRepository.delete(this.getCommentById(id));
    }

    public void commentExist(UUID id){
        this.getCommentById(id);
    }

    private void saveComment(Comment comment) {
        this.commentRepository.save(comment);
    }
}
