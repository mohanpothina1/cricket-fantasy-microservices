package com.score_service;

import model.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.ScoreRepository;
import service.ScoreService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ScoreServiceTest {

    @Mock
    private ScoreRepository scoreRepository;

    @InjectMocks
    private ScoreService scoreService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetScoreSummary() {
        String matchId = "match123";

        List<Score> mockScores = new ArrayList<>();

        Score s1 = new Score();
        s1.setMatchId(matchId);
        s1.setTeamName("India");
        s1.setOver(1);
        s1.setBall(2);
        s1.setRuns(4);
        s1.setWicket(false);

        Score s2 = new Score();
        s2.setMatchId(matchId);
        s2.setTeamName("India");
        s2.setOver(1);
        s2.setBall(3);
        s2.setRuns(6);
        s2.setWicket(true);

        mockScores.add(s1);
        mockScores.add(s2);

        when(scoreRepository.findByMatchId(matchId)).thenReturn(mockScores);

        String result = scoreService.getScoreSummary(matchId);

        // Should return: "India 10/1 (1.5 overs)"
        assertEquals("India 10/1 (1.5 overs)", result);
    }
}
