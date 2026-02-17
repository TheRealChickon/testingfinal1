package com.example.finaltest1;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "high_score")
public class HighScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private int score;

    private String name;






    // Getters and Setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
