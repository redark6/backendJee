package fr.esgi.cookRecipe.Domain.Social.Repository;

import fr.esgi.cookRecipe.Domain.Social.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

}
