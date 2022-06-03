package fr.esgi.cookRecipe.Social.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "r_user_like_recipe")
public class R_UserLikesRecipe extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "liked")
    private boolean liked;
}