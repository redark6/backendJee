package fr.esgi.cookRecipe.domain.util.entity;

import fr.esgi.cookRecipe.domain.product.entity.Product;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "product_log")
public class ProductLog {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;

    @Column(name = "count")
    private long count;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "researchs",referencedColumnName = "id")
    private List<ResearchLog> researches;
}
