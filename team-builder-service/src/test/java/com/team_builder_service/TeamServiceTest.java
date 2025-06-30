package com.team_builder_service;

import model.Player;
import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.TeamRepository;
import service.TeamService;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    private Team team;

    @BeforeEach
    public void setup() {
        team = new Team();
        team.setId("1");
        team.setTeamName("Avengers");
        team.setUserId("user123");

        Player player = new Player();
        player.setName("Iron Man");
        player.setRole("Batsman");
        player.setTeam("Avengers");

        team.setPlayers(List.of(player));
    }

    @Test
    public void testCreateTeam() {
        when(teamRepository.save(any(Team.class))).thenReturn(team);

        Team saved = teamService.createTeam(team);

        assertNotNull(saved);
        assertEquals("Avengers", saved.getTeamName());
        verify(teamRepository, times(1)).save(team);
    }

    @Test
    public void testGetAllTeams() {
        when(teamRepository.findAll()).thenReturn(List.of(team));

        List<Team> teams = teamService.getAllTeams();

        assertEquals(1, teams.size());
        verify(teamRepository, times(1)).findAll();
    }

    @Test
    public void testGetTeamById() {
        when(teamRepository.findById("1")).thenReturn(Optional.of(team));

        Team found = teamService.getTeamById("1");

        assertNotNull(found);
        assertEquals("Avengers", found.getTeamName());
        verify(teamRepository, times(1)).findById("1");
    }

    @Test
    public void testDeleteTeam() {
        doNothing().when(teamRepository).deleteById("1");

        teamService.deleteTeam("1");

        verify(teamRepository, times(1)).deleteById("1");
    }
}
