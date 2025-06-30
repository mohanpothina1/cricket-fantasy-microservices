package model;



public class Player {

    private String name;
    private String role;
    private String team;

    public Player() {
    }

    public Player(String name, String role, String team) {
        this.name = name;
        this.role = role;
        this.team = team;
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
}
