package fr.esgi.cookRecipe.Domain.Product.Entity;

import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "product")
public class Product extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "mesure_id")
    private MeasureUnit mesure;

    @ManyToOne
    @JoinColumn(name = "nutri_score_id")
    private NutriScore nutriScore;

    /*
    public static int nutriScoreMapping(){
        switch(nutriScore.getGrade()){
            case 'A': return 5;
            case 'B': return 4;
            case 'C': return 3;
            case 'D': return 2;
            case 'E': return 1;
            default: return -1;
        }
    }

     */
}