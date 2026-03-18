package com.example.finaltest1;

import jakarta.persistence.*;

@Entity
@Table(name = "high_score")
public class HighScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;
    private int time;
    private String name;


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    // public Long getId() { return id; }
    // public void setId(Long id) { this.id = id; }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}