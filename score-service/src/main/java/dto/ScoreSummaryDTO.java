package dto;

public class ScoreSummaryDTO {

    private String matchId;
    private String score;

    public ScoreSummaryDTO() {
    }

    public ScoreSummaryDTO(String matchId, String score) {
        this.matchId = matchId;
        this.score = score;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
