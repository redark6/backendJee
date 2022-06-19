package fr.esgi.cookRecipe.Domain.Social.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_rates_recipe")
public class UserRatesRecipe {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "recipe_id")
    private UUID recipeId;

    @Column(name = "rate")
    private double rate;

    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "user_id")
    private String userId;
}