package com.player_service;

import model.Player;
import model.Stats;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.PlayerRepository;
import service.PlayerService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    public PlayerServiceTest(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetPlayerById() {

        Stats stats = new Stats();
        stats.setMatches(100);
        stats.setRuns(8000);
        stats.setBattingAvg(52.0);
        stats.setStrikeRate(90.5);
        stats.setWickets(10);
        stats.setBowlingAvg(45.0);
        stats.setEconomy(5.5);

        // Create Player object with nested Stats
        Player mockPlayer = new Player();
        mockPlayer.setId("p1");
        mockPlayer.setName("Virat Kohli");
        mockPlayer.setRole("Batsman");
        mockPlayer.setTeam("India");
        mockPlayer.setStats(stats);

        // Mock repository behavior
        when(playerRepository.findById("p1")).thenReturn(Optional.of(mockPlayer));

        // Call the method to test
        Player result = playerService.getPlayerById("p1");

        // Assert result
        assertNotNull(result);
        assertEquals("Virat Kohli", result.getName());
        assertEquals("India", result.getTeam());
        assertEquals(8000, result.getStats().getRuns());
        assertEquals(52.0, result.getStats().getBattingAvg());
    }

    @Test
    void testAddPlayer() {
        Stats stats = new Stats();
        stats.setMatches(100);
        stats.setRuns(8000);
        stats.setBattingAvg(50.5);
        stats.setStrikeRate(90.1);
        stats.setWickets(0);
        stats.setBowlingAvg(0.0);
        stats.setEconomy(0.0);

        Player newPlayer = new Player("p2", "MS Dhoni", "Wicket Keeper", "India", stats);

        when(playerRepository.save(newPlayer)).thenReturn(newPlayer);

        Player savedPlayer = playerService.addPlayer(newPlayer);

        assertNotNull(savedPlayer);
        assertEquals("MS Dhoni", savedPlayer.getName());

        verify(playerRepository, times(1)).save(newPlayer);
    }


}
