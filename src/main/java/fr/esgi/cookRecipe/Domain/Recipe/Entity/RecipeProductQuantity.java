package fr.esgi.cookRecipe.Domain.Recipe.Entity;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "recipe_product_quantity")
public class RecipeProductQuantity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity") // in grams for weight and unit for unit measurable product
    private int quantity;
}