package com.example.finaltest1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HighScoreRepository extends JpaRepository<HighScore, Long> {

    public Optional<HighScore> findByName(String name);

}
