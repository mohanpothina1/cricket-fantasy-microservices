package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PlayerDTO {

    private String id;
    private String name;
    private String role;
    private String team;
    private Stats stats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Stats {
        private int matches;
        private int runs;
        private double battingAvg;
        private double strikeRate;

        // Optional: For bowlers
        private int wickets;
        private double bowlingAvg;
        private double economy;

        public int getMatches() {
            return matches;
        }

        public void setMatches(int matches) {
            this.matches = matches;
        }

        public int getRuns() {
            return runs;
        }

        public void setRuns(int runs) {
            this.runs = runs;
        }

        public double getBattingAvg() {
            return battingAvg;
        }

        public void setBattingAvg(double battingAvg) {
            this.battingAvg = battingAvg;
        }

        public double getStrikeRate() {
            return strikeRate;
        }

        public void setStrikeRate(double strikeRate) {
            this.strikeRate = strikeRate;
        }

        public int getWickets() {
            return wickets;
        }

        public void setWickets(int wickets) {
            this.wickets = wickets;
        }

        public double getBowlingAvg() {
            return bowlingAvg;
        }

        public void setBowlingAvg(double bowlingAvg) {
            this.bowlingAvg = bowlingAvg;
        }

        public double getEconomy() {
            return economy;
        }

        public void setEconomy(double economy) {
            this.economy = economy;
        }
    }
}
