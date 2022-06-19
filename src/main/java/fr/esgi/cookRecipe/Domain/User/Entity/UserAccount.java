package fr.esgi.cookRecipe.Domain.User.Entity;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractPersistable {

    @EmbeddedId
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "username") // -> the true username
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(targetEntity = Recipe.class)
    @JoinColumn(name = "recipies")
    private List<Recipe> recipies;

    @Column(name = "inscription_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date inscriptionDate;
}