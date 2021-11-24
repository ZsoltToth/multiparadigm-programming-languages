package hu.uni.ekcu.java.service;

import hu.uni.ekcu.java.model.Player;
import hu.uni.ekcu.java.persist.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final PlayerRepository playerRepository;

    private final EloRatingCalculator eloRatingCalculator;


    @Override
    public void recordGameResult(Player winner, Player loser) {
        EloRatingCalculator.Scores updatedScores = eloRatingCalculator.calculate(
            new EloRatingCalculator.Scores(
                winner.getScore(),
                loser.getScore()
            ));
        winner.setScore(updatedScores.getWinner());
        loser.setScore(updatedScores.getLoser());
        playerRepository.save(winner);
        playerRepository.save(loser);
    }
}
