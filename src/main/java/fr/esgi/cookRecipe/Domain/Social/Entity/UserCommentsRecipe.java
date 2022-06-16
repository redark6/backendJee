package fr.esgi.cookRecipe.Domain.Social.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_comments_recipe")
public class UserCommentsRecipe extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "comment_id")
    private UUID comment_id;

    @Column(name = "recipe_id")
    private UUID recipeId;
}