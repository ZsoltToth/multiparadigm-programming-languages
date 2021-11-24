package hu.uni.ekcu.java.service;

import hu.uni.ekcu.java.model.Player;
import hu.uni.ekcu.java.persist.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class RatingServiceImplTest {

    @Mock
    private PlayerRepository repository;

    private static final int ADJUSTMENT = 5;

    private RatingServiceImpl service;

    @BeforeEach
    public void setUp(){
        service = new RatingServiceImpl(repository, ADJUSTMENT);
    }


    @Test
    public void recordGameResultsHappyPath(){
       // given
        Player winner = new Player("winner", 10);
        Player loser = new Player("loser", 10);

        Player winnerUpdated = new Player("winner", 15);
        Player loserUpdated = new Player("loser", 5);

        when(repository.save(winnerUpdated)).thenReturn(winnerUpdated);
        when(repository.save(loserUpdated)).thenReturn(loserUpdated);
       // when
        service.recordGameResult(winner, loser);
       // then

    }
}