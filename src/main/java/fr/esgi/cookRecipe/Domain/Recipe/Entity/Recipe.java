package fr.esgi.cookRecipe.Domain.Recipe.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "shares")
    private int shares;

    @Column(name = "execution_time") // in second
    private Long executionTime;

    @Column(name = "price")
    private double price;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_quantity",referencedColumnName = "id")
    private List<RecipeProductQuantity> products;

    @Column(name = "nutri_score_id")
    public int getNutriScoreId() {
        //return this.products.stream().map(ProductQuantity::getProduct).reduce(Product::nutriscoreMapping).;
        return 5;
    }
}