package fr.esgi.cookRecipe.Domain.Util.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "currency")
public class Currency extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "country")
    private String country;

    @Column(name = "currency")
    private String currency;
}