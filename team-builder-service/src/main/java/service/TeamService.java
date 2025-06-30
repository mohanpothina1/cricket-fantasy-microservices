package service;


import model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TeamRepository;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team){
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamById(String id){
        return teamRepository.findById(id).orElseThrow(()-> new RuntimeException("Team not found"));
    }

    public List<Team> getTeamsByUserId(String userId){
        return teamRepository.findByUserId(userId);
    }

    public Team updateTeam(String id, Team updatedTeam){
        Team existing = getTeamById(id);
        existing.setTeamName(updatedTeam.getTeamName());
        existing.setPlayers(updatedTeam.getPlayers());
        return teamRepository.save(existing);
    }

    public void deleteTeam(String id){
        teamRepository.deleteById(id);
    }
}
