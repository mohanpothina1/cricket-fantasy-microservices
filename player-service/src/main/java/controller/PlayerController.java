package controller;


import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @PostMapping
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable String id){
        return playerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public  Player updatePlayer(@PathVariable String id, @RequestBody Player player){
        return playerService.updatePlayer(id,player);
    }

    @PatchMapping("/{id}")
    public Player updatePlayerPartially(@PathVariable String id, @RequestBody Player updatedPlayer){
        return playerService.updatePlayerPartially(id,updatedPlayer);
    }

    @DeleteMapping
    public void deletePlayer(@PathVariable String id){
        playerService.deletePlayer(id);
    }
}
