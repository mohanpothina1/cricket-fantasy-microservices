package controller;


import dto.PlayerDTO;
import jakarta.validation.Valid;
import model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PlayerClient;
import service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @Autowired
    private PlayerClient playerClient;


    @GetMapping("/player/{id}")
    public PlayerDTO getPlayer(@PathVariable String id) {
        return playerClient.getPlayerById(id);
    }



    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody @Valid Team team){
        return new ResponseEntity<>(teamService.createTeam(team), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable String id){
        return teamService.getTeamById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Team> getTeamsByUser(@PathVariable String userId){
        return teamService.getTeamsByUserId(userId);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable String id, @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String id){
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
