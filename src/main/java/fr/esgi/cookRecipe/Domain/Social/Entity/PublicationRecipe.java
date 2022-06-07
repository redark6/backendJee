package fr.esgi.cookRecipe.Domain.Social.Entity;

import fr.esgi.cookRecipe.Domain.Recipe.Entity.Recipe;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "publication_recipe")
public class PublicationRecipe extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recipe_Id")
    private Recipe recipe;

    @OneToMany
    @Column(name = "comments_id")
    private List<UserCommentsRecipe> comments;

    @OneToMany
    @Column(name = "likes_id")
    private List<UserCommentsRecipe> likes;

    @OneToMany
    @Column(name = "rates_id")
    private List<UserCommentsRecipe> rates;

}

