package fr.esgi.cookRecipe.Domain.Util.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "log")
public class Log extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "id_recipe")
    private String idRecipe;

    @Column(name = "entitled")
    private String entitled;

    @Column(name = "execution_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date executionDate;
}