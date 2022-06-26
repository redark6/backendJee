package fr.esgi.cookRecipe.Domain.Product.Entity;

import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "mesure_id",referencedColumnName = "id")
    private MeasureUnit mesure;

    @ManyToOne
    @JoinColumn(name = "nutri_score_id",referencedColumnName = "id")
    private NutriScore nutriScore;

}