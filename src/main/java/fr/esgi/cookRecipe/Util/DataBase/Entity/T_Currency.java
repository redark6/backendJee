package fr.esgi.cookRecipe.Util.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "t_currency")
public class T_Currency extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "currency")
    private String currency;
}