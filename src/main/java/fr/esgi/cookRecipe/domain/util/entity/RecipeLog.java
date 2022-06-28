package fr.esgi.cookRecipe.domain.util.entity;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "recipe_log")
public class RecipeLog {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id",referencedColumnName = "id")
    private Recipe recipe;

    @Column(name = "count")
    private long count;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "researchs",referencedColumnName = "id")
    private List<ResearchLog> researches;
}
