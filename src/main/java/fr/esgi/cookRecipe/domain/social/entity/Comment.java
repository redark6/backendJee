package fr.esgi.cookRecipe.domain.social.entity;

import fr.esgi.cookRecipe.domain.recipe.entity.Recipe;
import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "body")
    private String body;

    @Column(name = "posted_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date postedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id",referencedColumnName = "id")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserAccount user;

}