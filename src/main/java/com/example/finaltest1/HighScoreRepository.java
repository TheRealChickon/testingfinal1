package com.example.finaltest1;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public interface HighScoreRepository extends JpaRepository<HighScore, Long> {

    Optional<HighScore> findByName(String name);

//    @Override
//    @Query("SELECT h FROM HighScore h ORDER BY h.score DESC")
//    public List<HighScore> findAll();

    // List<HighScore> findTop6ByOrderByScoreDesc();


    @Override
    default List<HighScore> findAll() {
        return findAll(Sort.unsorted()).stream().sorted(Comparator.comparing(HighScore::getScore).reversed().thenComparing(HighScore::getTime)).limit(6).toList();
    }


}