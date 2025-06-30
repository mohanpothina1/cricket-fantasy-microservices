package controller;

import model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.MatchService;

import java.util.List;


@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match){
       return new ResponseEntity<>(matchService.createMatch(match), HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Match>> getAllMatches(){
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id){
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match){
        return ResponseEntity.ok(matchService.updateMatch(id, match));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Match> patchMatch(@PathVariable Long id, @RequestBody Match partialMatch) {
        Match updated = matchService.patchMatch(id, partialMatch);
        return ResponseEntity.ok(updated);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id){
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
