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
    private UUID recipeId;

    @Column(name = "rate")
    private double rate;

    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "user_id")
    private String userId;
}