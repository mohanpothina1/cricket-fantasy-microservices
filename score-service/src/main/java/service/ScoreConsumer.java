package service;


import dto.ScoreEvent;
import model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import repository.ScoreRepository;

@Component
public class ScoreConsumer {

    @Autowired
    private ScoreRepository scoreRepository;

    @KafkaListener(topics = "score_topic", groupId = "score-group")
    public void consume(ScoreEvent event) {
        Score score = new Score();
        score.setMatchId(event.getMatchId());
        score.setOver(event.getOver());
        score.setBall(event.getBall());
        score.setBatsman(event.getBatsman());
        score.setBowler(event.getBowler());
        score.setRuns(event.getRuns());
        score.setWicket(event.isWicket());
        score.setTeamName(event.getTeamName());

        scoreRepository.save(score);
    }
}
