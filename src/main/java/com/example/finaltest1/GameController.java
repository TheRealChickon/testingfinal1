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

    // Holt den bestehenden Spieler oder erstellt einen neuen, falls der Name zum ersten Mal auftaucht
    HighScore h = repository.findByName(name).orElse(new HighScore());
    boolean isNewPlayer = (h.getName() == null);
    boolean beatHighScore = (newScore > h.getScore());
    boolean sameScoreButFaster = (newScore == h.getScore() && time < h.getTime());

    // Speichert nur, wenn der Spieler komplett neu ist ODER den alten Score geknackt hat
    if (h.getName() == null || newScore > h.getScore()) {
        h.setName(name);
        h.setScore(newScore);
        h.setTime(time); // Zeit wird mitgespeichert, filtert aber nicht
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
