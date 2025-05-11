package se.lexicon.marketplace_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;


    private String description;


    private LocalDate expirationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Advertisement(User user, String title, String description, LocalDate expirationDate) {
        this.user = user;
        this.expirationDate = expirationDate;
        this.description = description;
        this.title = title;
    }
}
