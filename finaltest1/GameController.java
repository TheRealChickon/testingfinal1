package com.example.finaltest1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model; // Don't forget this import if it's missing

@Controller
public class GameController {

    @Autowired
    private HighScoreRepository repository;

    @PostMapping("/score")
    @ResponseBody
    public void saveHighScore(@RequestParam int newScore) {
        HighScore h = repository.findById(1L).orElse(new HighScore());

        h.setId(1L);

        if (newScore > h.getScore()) {
            h.setScore(newScore);
            repository.save(h);
        }
    }

    @GetMapping("/")
    public String showGame(Model model) {
        // Fetch the score, defaulting to 0 if not found
        int currentScore = repository.findById(1L).map(HighScore::getScore).orElse(0);

        // Add it to the model so Thymeleaf can use ${highscore}
        model.addAttribute("highscore", currentScore);
        return "index";
    }
}