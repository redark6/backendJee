package fr.esgi.cookRecipe.Domain.Social.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_rates_recipe")
public class UserRatesRecipe extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "rate")
    private int rate;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "user_id")
    private Long userId;
}