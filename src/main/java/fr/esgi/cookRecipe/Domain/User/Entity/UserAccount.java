package fr.esgi.cookRecipe.Domain.User.Entity;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "username") // -> the true username
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany
    @JoinColumn(name = "recipies")
    private List<Recipe> recipies;

    @Column(name = "inscription_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date inscriptionDate;
}