package fr.esgi.cookRecipe.Social.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "r_user_comments_recipe")
public class R_UserCommentsRecipe extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "comment_id")
    private Long comment_id;

    @Column(name = "recipe_id")
    private Long recipeId;
}