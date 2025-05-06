package se.lexicon.marketplace_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

//  todo cascade, fetch
    @OneToMany(mappedBy = "user")
//  todo: why should be initialized?
    private Set<Advertisement> advertisement = new HashSet<>();

}
