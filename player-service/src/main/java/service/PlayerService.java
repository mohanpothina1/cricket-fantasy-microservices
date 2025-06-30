package service;


import exception.PlayerNotFoundException;
import model.Player;
import model.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player addPlayer (Player player){
        return playerRepository.save(player);
    }

    public List<Player>  getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(String id){
        return playerRepository.findById(id)
                .orElseThrow(()-> new PlayerNotFoundException("Player not found with ID: " + id));
    }

    public Player updatePlayer(String id, Player updatedPlayer){
        Player player =  getPlayerById(id);
        player.setName(updatedPlayer.getName());
        player.setRole(updatedPlayer.getRole());
        player.setTeam(updatedPlayer.getTeam());
        player.setStats(updatedPlayer.getStats());

        return playerRepository.save(player);
    }
    public Player updatePlayerPartially(String id, Player updatedPlayer) {
        Player existingPlayer = getPlayerById(id); // throws exception if not found

        // Update top-level fields only if present
        if (updatedPlayer.getName() != null)
            existingPlayer.setName(updatedPlayer.getName());

        if (updatedPlayer.getRole() != null)
            existingPlayer.setRole(updatedPlayer.getRole());

        if (updatedPlayer.getTeam() != null)
            existingPlayer.setTeam(updatedPlayer.getTeam());

        // Handle nested stats update
        if (updatedPlayer.getStats() != null) {
            Stats existingStats = existingPlayer.getStats();
            Stats newStats = updatedPlayer.getStats();

            if (existingStats == null)
                existingStats = new Stats();

            if (newStats.getMatches() != 0)
                existingStats.setMatches(newStats.getMatches());

            if (newStats.getRuns() != null)
                existingStats.setRuns(newStats.getRuns());

            if (newStats.getBattingAvg() != null)
                existingStats.setBattingAvg(newStats.getBattingAvg());

            if (newStats.getStrikeRate() != null)
                existingStats.setStrikeRate(newStats.getStrikeRate());

            if (newStats.getWickets() != null)
                existingStats.setWickets(newStats.getWickets());

            if (newStats.getBowlingAvg() != null)
                existingStats.setBowlingAvg(newStats.getBowlingAvg());

            if (newStats.getEconomy() != null)
                existingStats.setEconomy(newStats.getEconomy());

            existingPlayer.setStats(existingStats);
        }

        return playerRepository.save(existingPlayer);
    }


    public void deletePlayer(String id){
        playerRepository.deleteById(id);
    }
}
