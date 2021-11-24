package hu.uni.ekcu.java.service;

import hu.uni.ekcu.java.model.Player;

public interface RatingService {

    void recordGameResult(Player winner, Player loser);
}
