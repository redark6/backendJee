package fr.esgi.cookRecipe.Domain.User.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "authority")
    private String authority;
}