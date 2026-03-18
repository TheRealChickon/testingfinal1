package com.example.finaltest1;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Repository
public interface HighScoreRepository extends JpaRepository<HighScore, Long> {

    public Optional<HighScore> findByName(String name);
//
//    @Override
//    @Query("SELECT h FROM HighScore h ORDER BY h.score DESC")
//    public List<HighScore> findAll();

//    List<HighScore> findTop6ByOrderByScoreDesc();


    @Override
    default List<HighScore> findAll() {

        return findAll(Sort.unsorted()).stream()
                .sorted(Comparator.comparing(HighScore::getScore).reversed()
                .thenComparing(HighScore::getTime))
                .limit(6)
                .toList();
    }

//    @Override
//    default List<HighScore> findAll() {
//        List<HighScore> scores = new ArrayList<>(findAll(Sort.unsorted()));
//        scores.sort(Comparator.comparing(HighScore::getScore));
//        return scores.subList(Math.max(0, scores.size() - 6), scores.size());
//    }


//
//    @Override
//    default List<HighScore> findAll(){
//        return findAll(PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "score"))).getContent();
//    }

//    @Override
//    default List<HighScore> findAll(){
//        List<HighScore> normalScores = findAll(Sort.unsorted());
//
}

