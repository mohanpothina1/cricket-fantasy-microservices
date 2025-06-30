package service;

import model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MatchRepository;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match createMatch(Match match){
      return  matchRepository.save(match);
    }

    public List<Match> getAllMatches(){
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id){
        return matchRepository.findById(id).orElseThrow(()-> new RuntimeException("Match not found"));
    }

    public Match updateMatch(Long id, Match updatedMatch){
        Match match = getMatchById(id);
        match.setTeamA(updatedMatch.getTeamA());
        match.setTeamB(updatedMatch.getTeamB());
        match.setVenue(updatedMatch.getVenue());
        match.setMatchDateTime(updatedMatch.getMatchDateTime());
        match.setResult(updatedMatch.getResult());
        return matchRepository.save(match);
    }

    public Match patchMatch(Long id, Match partialMatch) {
        Match existingMatch = getMatchById(id);

        if (partialMatch.getTeamA() != null) {
            existingMatch.setTeamA(partialMatch.getTeamA());
        }
        if (partialMatch.getTeamB() != null) {
            existingMatch.setTeamB(partialMatch.getTeamB());
        }
        if (partialMatch.getVenue() != null) {
            existingMatch.setVenue(partialMatch.getVenue());
        }
        if (partialMatch.getMatchDateTime() != null) {
            existingMatch.setMatchDateTime(partialMatch.getMatchDateTime());
        }
        if (partialMatch.getResult() != null) {
            existingMatch.setResult(partialMatch.getResult());
        }

        return matchRepository.save(existingMatch);
    }


    public void deleteMatch(Long id){
        matchRepository.deleteById(id);
    }



}
