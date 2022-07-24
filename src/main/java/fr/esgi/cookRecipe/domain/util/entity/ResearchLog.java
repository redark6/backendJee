package fr.esgi.cookRecipe.domain.util.entity;

import fr.esgi.cookRecipe.domain.user.entity.UserAccount;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "research_log")
public class ResearchLog {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "entitled", updatable = false)
    private String entitled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id", updatable = false)
    private UserAccount user;

    @Column(name = "execution_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date executionDate;
}


