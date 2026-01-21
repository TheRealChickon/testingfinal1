package com.example.finaltest1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "high_score")
public class HighScore {

    @Id
    private Long id;

    private int score;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}