package fr.esgi.cookRecipe.Domain.Util.Entity;

import fr.esgi.cookRecipe.Domain.Product.Entity.Product;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "researchs",referencedColumnName = "id")
    private List<ResearchLog> researches;
}
