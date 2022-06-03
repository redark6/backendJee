package fr.esgi.cookRecipe.Product.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "r_product_has_mesure")
public class R_ProductHasMesure extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity") // in grams for weight and unit for unit measurable product
    private int quantity;

    @Column(name = "measure_unit_id")
    private Long measureUnitId;
}