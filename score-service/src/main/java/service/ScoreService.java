package service;


import com.fasterxml.jackson.databind.ObjectMapper;
import dto.MatchDTO;
import dto.ScoreSummaryDTO;
import model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repository.ScoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    private List<Score> scoreList = new ArrayList<>();


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ScoreKafkaProducer scoreKafkaProducer;

    public String getScoreSummary(String matchId) {
        List<Score> scores = scoreRepository.findByMatchId(matchId);
        if (scores.isEmpty()) {
            return "No score data available.";
        }

        int totalRuns = scores.stream().mapToInt(Score::getRuns).sum();
        long totalWickets = scores.stream().filter(Score::isWicket).count();
        double totalOvers = scores.stream()
                .mapToDouble(score -> score.getOver() + score.getBall() / 6.0)
                .max().orElse(0.0);

        String teamName = scores.get(0).getTeamName();
        String summary = teamName + " " + totalRuns + "/" + totalWickets + " (" + String.format("%.1f", totalOvers) + " overs)";
        return summary;
    }


    public ScoreSummaryDTO getMatchSummary(String matchId) {
        String matchServiceUrl = "http://localhost:8083/matches/" + matchId;

        MatchDTO match = restTemplate.getForObject(matchServiceUrl, MatchDTO.class);
        String teamName = match != null ? match.getTeamName() : "Unknown";

        List<Score> matchScores = scoreList.stream()
                .filter(score -> score.getMatchId().equals(matchId))
                .collect(Collectors.toList());

        int totalRuns = matchScores.stream().mapToInt(Score::getRuns).sum();
        int totalWickets = (int) matchScores.stream().filter(Score::isWicket).count();
        int totalBalls = matchScores.size();

        int totalOvers = totalBalls / 6;
        int remainingBalls = totalBalls % 6;

        String summary = teamName + " " + totalRuns + "/" + totalWickets + " (" + totalOvers + " overs)";
        return new ScoreSummaryDTO(matchId, summary);
    }


    public void publishScoreSummary(String matchId) {
        List<Score> scores = scoreRepository.findByMatchId(matchId);

        if (scores.isEmpty()) {
            System.out.println("No scores found for match: " + matchId);
            return;
        }

        String teamName = scores.get(0).getTeamName(); // assuming all scores are for the same team
        int totalRuns = scores.stream().mapToInt(Score::getRuns).sum();
        long totalWickets = scores.stream().filter(Score::isWicket).count();
        int totalOvers = scores.stream().mapToInt(Score::getOver).max().orElse(0);

        String summary = teamName + " " + totalRuns + "/" + totalWickets + " (" + totalOvers + " overs)";

        ScoreSummaryDTO summaryDTO = new ScoreSummaryDTO();
        summaryDTO.setMatchId(matchId);
        summaryDTO.setScore(summary);

        try {
            String event = new ObjectMapper().writeValueAsString(summaryDTO);
            scoreKafkaProducer.sendScoreEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Score saveScore(Score score){
        Score saved = scoreRepository.save(score);
        try{
            String event = new ObjectMapper().writeValueAsString(saved);
            scoreKafkaProducer.sendScoreEvent(event);
        }catch (Exception e){
            e.printStackTrace();
        }
        return saved;
    }

    public List<Score> getScoresByMatch(String matchId){
        return scoreRepository.findByMatchId(matchId);
    }
}
