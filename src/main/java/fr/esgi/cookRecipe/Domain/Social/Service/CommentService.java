package fr.esgi.cookRecipe.Domain.Social.Service;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import fr.esgi.cookRecipe.Domain.Social.Repository.CommentRepository;
import fr.esgi.cookRecipe.Domain.Social.Entity.Comment;
import fr.esgi.cookRecipe.Domain.User.Entity.UserAccount;
import kernel.NoSuchEntityException;
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

    public Comment getCommentById(UUID id) {
        Optional<Comment> comment = this.commentRepository.findById(id);
        if(comment.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"comment");
        }
        return comment.get();
    }

    public List<Comment> getCommentsByRecipe(Recipe recipe) {
        return this.commentRepository.getAllByRecipe(recipe);
    }

    public void addComment(Comment comment) {
        this.saveComment(comment);
    }

    public void removeCommentById(UUID id) {
        this.commentRepository.delete(this.getCommentById(id));
    }

    public int getUserCommentCount(UserAccount user){
        return this.commentRepository.countCommentsByUser(user);
    }

    private void saveComment(Comment comment) {
        this.commentRepository.save(comment);
    }
}
