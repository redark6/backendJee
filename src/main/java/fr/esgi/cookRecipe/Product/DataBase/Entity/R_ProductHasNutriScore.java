package fr.esgi.cookRecipe.Product.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "r_product_has_nutri_score")
public class R_ProductHasNutriScore extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "product_id")
    private char productId;

    @Column(name = "nutri_score_id")
    private char nutriScoreId;
}