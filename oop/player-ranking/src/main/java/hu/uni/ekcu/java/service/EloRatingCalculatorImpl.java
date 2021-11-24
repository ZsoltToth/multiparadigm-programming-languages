package hu.uni.ekcu.java.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EloRatingCalculatorImpl implements EloRatingCalculator {

    private final int adjustment;

    @Override
    public Scores calculate(Scores scores) {
        double winnerChance = calculateWinChance(scores.getWinner(), scores.getLoser());
        double loserChance = calculateWinChance(scores.getLoser(), scores.getWinner());
        return new Scores(
            scores.getWinner() + (int) Math.round(adjustment * (1.0 - winnerChance)),
            scores.getLoser() + (int) Math.round(adjustment * (0.0 - loserChance))
        );
    }

    private double calculateWinChance(int scoreA, int scoreB) {
        return 1.0 / (1.0 + Math.pow(10, (scoreB - scoreA) / 400.0));
    }
}
