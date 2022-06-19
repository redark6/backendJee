package fr.esgi.cookRecipe.Domain.Recipe.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "recipe")
public class Recipe extends AbstractPersistable {

    @EmbeddedId
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

    @OneToMany(fetch = FetchType.LAZY,targetEntity = RecipeProductQuantity.class)
    @JoinColumn(name = "product_quantity")
    private List<RecipeProductQuantity> products;

    @Column(name = "nutri_score_id")
    public int getNutriScoreId() {
        //return this.products.stream().map(ProductQuantity::getProduct).reduce(Product::nutriscoreMapping).;
        return 5;
    }
}