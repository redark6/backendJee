package fr.esgi.cookRecipe.User.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user_account")
public class T_UserAccount extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "mail")
    private String mail;

    @Column(name = "inscription_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date inscriptionDate;
}