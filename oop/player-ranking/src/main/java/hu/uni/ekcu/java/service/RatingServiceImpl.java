package hu.uni.ekcu.java.service;

import hu.uni.ekcu.java.model.Player;
import hu.uni.ekcu.java.persist.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final PlayerRepository playerRepository;

    private final int adjustment;

    public RatingServiceImpl(PlayerRepository playerRepository, int adjustment) {
        this.playerRepository = playerRepository;
        this.adjustment = adjustment;
    }

    @Override
    public void recordGameResult(Player winner, Player loser) {
        winner.setScore(winner.getScore() + adjustment);
        loser.setScore(loser.getScore() - adjustment);
        playerRepository.save(winner);
        playerRepository.save(loser);
    }
}
