package com.example.finaltest1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class Finaltest1ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testHighScoreGettersAndSetters() {
        HighScore highScore = new HighScore();
        highScore.setName("Player1");
        highScore.setScore(150);

        assertEquals("Player1", highScore.getName());
        assertEquals(150, highScore.getScore());
    }

    @Test
    void testHighScoreDefaultValues() {
        HighScore highScore = new HighScore();

        assertNull(highScore.getName());
        assertEquals(0, highScore.getScore());
    }
}