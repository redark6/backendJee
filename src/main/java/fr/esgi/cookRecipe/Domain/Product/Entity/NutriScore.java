package fr.esgi.cookRecipe.Domain.Product.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "nutris_score")
public class NutriScore extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "grade")
    private char grade;
}