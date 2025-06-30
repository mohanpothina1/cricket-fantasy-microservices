package model;

public class Stats {

    private int matches;

    //Batsmen related
    private Integer runs;
    private Double battingAvg;
    private Double strikeRate;


    //Bowler related

    private Integer wickets;

    private Double bowlingAvg;

    private Double economy;


    public Stats() {
    }

    public Stats(int matches, Integer runs, Double battingAvg, Double strikeRate, Integer wickets, Double bowlingAvg, Double economy) {
        this.matches = matches;
        this.runs = runs;
        this.battingAvg = battingAvg;
        this.strikeRate = strikeRate;
        this.wickets = wickets;
        this.bowlingAvg = bowlingAvg;
        this.economy = economy;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Double getBattingAvg() {
        return battingAvg;
    }

    public void setBattingAvg(Double battingAvg) {
        this.battingAvg = battingAvg;
    }

    public Double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(Double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Double getBowlingAvg() {
        return bowlingAvg;
    }

    public void setBowlingAvg(Double bowlingAvg) {
        this.bowlingAvg = bowlingAvg;
    }

    public Double getEconomy() {
        return economy;
    }

    public void setEconomy(Double economy) {
        this.economy = economy;
    }
}
