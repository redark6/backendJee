package fr.esgi.cookRecipe.Domain.Social.Repository;

import fr.esgi.cookRecipe.Domain.Social.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    /*
    @Query(value = "SELECT c.id, c.body, ucr.user_id, ua.username, c.posted_date FROM comment AS c LEFT JOIN user_comments_recipe AS ucr ON c.id == ucr.recipe_id LEFT JOIN user_account AS ua ON ucr.user_id == ua.id",
                    //"SELECT c.id,c.body,c.posted_date,ucr.user_id,ua.username FROM comment AS c,user_comments_recipe AS ucr,user_account AS ua INNER JOIN user_comments_recipe AS ucr On c.id == ucr.recipe_id INNER JOIN user_account AS ua ON ucr.user_id == ua.email",
            nativeQuery = true)
    List<Comment> find(Iterable<UUID> uuids);

     */
}
