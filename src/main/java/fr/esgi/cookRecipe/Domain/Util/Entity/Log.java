package fr.esgi.cookRecipe.Domain.Util.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "id_element") // could be a recipe or a product
    private String idElement;

    @Column(name = "entitled")
    private String entitled;

    @Column(name = "execution_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date executionDate;
}