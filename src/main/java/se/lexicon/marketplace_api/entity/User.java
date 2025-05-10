package se.lexicon.marketplace_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

//  todo cascade, fetch
    @OneToMany(mappedBy = "user")
//  todo: why should be initialized?
    private Set<Advertisement> advertisement = new HashSet<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
