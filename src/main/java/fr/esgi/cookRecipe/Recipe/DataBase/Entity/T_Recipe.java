package fr.esgi.cookRecipe.Recipe.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "t_recipe")
public class T_Recipe extends AbstractPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shares")
    private int shares;

    @Column(name = "execution_time") // in second
    private Long executionTime;

    @Column(name = "price")
    private double price;

    @Column(name = "nutri_score_id")
    private Long NutriScoreId;
}