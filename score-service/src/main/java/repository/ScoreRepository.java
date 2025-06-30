package repository;

import model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    List<Score> findByMatchId(String matchId);
    Optional<Score> findFirstByMatchId(String matchId);

}
