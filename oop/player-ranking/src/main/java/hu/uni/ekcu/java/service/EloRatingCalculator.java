package hu.uni.ekcu.java.service;

import lombok.Data;

public interface EloRatingCalculator {

    Scores calculate(Scores scores);

    @Data
    public static class Scores {

        private final int winner;

        private final int loser;
    }
}
