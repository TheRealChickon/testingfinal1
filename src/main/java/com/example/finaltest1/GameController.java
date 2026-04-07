package com.example.finaltest1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private HighScoreRepository repository;

    @Autowired
    private HighScoreSorter highScoreSorter;

    @PostMapping("/score")
    @ResponseBody
    public HighScore saveHighScore(@RequestParam int newScore,
                                   @RequestParam String name,
                                   @RequestParam int time) {

        HighScore h = repository.findByName(name).orElse(new HighScore());

        h.setName(name);
        h.setTime(time);

        if (newScore > h.getScore() || h.getTime() < time) {
            h.setScore(newScore);
            repository.save(h);
        }

        return h;
    }

    @GetMapping("/")
    public String showGame(Model model) {

        List<HighScore> allScores = repository.findAll();
        List<HighScore> sortedScores = highScoreSorter.sort(allScores);

        model.addAttribute("highscores", sortedScores);

        return "index";
    }
}