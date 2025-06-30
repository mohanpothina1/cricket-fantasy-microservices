package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ScoreKafkaProducer;
import service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreKafkaProducer producer;

    @PostMapping
    public ResponseEntity<Score> addScore(@RequestBody Score score) {
        Score savedScore = scoreService.saveScore(score);

        try {
            // Convert to JSON and send to Kafka
            ObjectMapper mapper = new ObjectMapper();
            String message = mapper.writeValueAsString(savedScore);

            producer.sendScoreEvent(message);
            System.out.println("✅ Sent to Kafka: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(savedScore, HttpStatus.CREATED);
    }

    @PostMapping("/summary/{matchId}")
    public String publishSummary(@PathVariable String matchId) {
        scoreService.publishScoreSummary(matchId);
        return "Score summary published for match ID: " + matchId;
    }

    @GetMapping("/match/{matchId}")
    public List<Score> getMatchScores(@PathVariable String matchId) {
        return scoreService.getScoresByMatch(matchId);
    }
}
