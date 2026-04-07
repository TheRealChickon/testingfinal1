package com.example.finaltest1;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class HighScoreSorter {

    public List<HighScore> sort(List<HighScore> scores) {
        List<HighScore> result = new ArrayList<>(scores);

        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = 0; j < result.size() - 1 - i; j++) {
                HighScore a = result.get(j);
                HighScore b = result.get(j + 1);

                if (a.getScore() < b.getScore()) {
                    result.set(j, b);
                    result.set(j + 1, a);
                }
            }
        }

        return result;
    }
}