package fr.esgi.cookRecipe.Domain.Social.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_comments_recipe")
public class UserCommentsRecipe {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "comment_id")
    private UUID commentId;

    @Column(name = "recipe_id")
    private UUID recipeId;
}