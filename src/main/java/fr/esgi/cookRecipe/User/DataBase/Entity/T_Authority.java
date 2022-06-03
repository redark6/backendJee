package fr.esgi.cookRecipe.User.DataBase.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class T_Authority extends AbstractPersistable {

    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "authority")
    private String authority;
}