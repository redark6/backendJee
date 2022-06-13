package fr.esgi.cookRecipe.Domain.Recipe.Entity;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "recipe_product_quantity")
public class RecipeProductQuantity extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity") // in grams for weight and unit for unit measurable product
    private int quantity;
}