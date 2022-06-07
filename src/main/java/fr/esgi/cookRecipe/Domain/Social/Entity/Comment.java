package fr.esgi.cookRecipe.Domain.Social.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "comment")
public class Comment extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "body")
    private String body;

    @Column(name = "posted_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date postedDate;

}