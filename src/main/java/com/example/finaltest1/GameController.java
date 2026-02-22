package com.example.finaltest1;

import jakarta.persistence.Id;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class GameController {

    @Autowired
    private HighScoreRepository repository;

    @PostMapping("/score")
    @ResponseBody
    public void saveHighScore(@RequestParam int newScore,@RequestParam String name) {

        HighScore h = repository.findByName(name).orElse(new HighScore());

        h.setName(name);


        if (h.getName().equals(name) && newScore > h.getScore()) {
            h.setScore(newScore);
            repository.save(h);
        }

    }

    @GetMapping("/")
    public String showGame(Model model) {

        // int currentScore = repository.findById(1L).map(HighScore::getScore).orElse(0);

        model.addAttribute("highscores", repository.findAll());

        // model.addAttribute("highscores", currentScore);
        return "index";
    }
}
