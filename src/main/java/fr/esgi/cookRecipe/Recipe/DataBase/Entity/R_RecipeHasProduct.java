package fr.esgi.cookRecipe.Recipe.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "r_recipe_has_product")
public class R_RecipeHasProduct extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "recipe_id")
    private String recipeId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "product_id")
    private boolean productId;
}