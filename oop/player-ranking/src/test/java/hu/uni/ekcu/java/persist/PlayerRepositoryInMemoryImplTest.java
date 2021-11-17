package hu.uni.ekcu.java.persist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import hu.uni.ekcu.java.model.Player;
import hu.uni.ekcu.java.persist.exceptions.PlayerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;


class PlayerRepositoryInMemoryImplTest {

    private PlayerRepositoryInMemoryImpl repository;

    @BeforeEach
    public void setUp(){
       repository = new PlayerRepositoryInMemoryImpl(
           List.of(
               TestDataProvider.ALICE,
               TestDataProvider.BOB,
               TestDataProvider.CHARLIE
           )
       );
    }

    @Test
    void readAll() {
        // given
        Collection<Player> expected = List.of(
            TestDataProvider.ALICE,
            TestDataProvider.BOB,
            TestDataProvider.CHARLIE
        );
        // when
        Collection<Player> actual = repository.readAll();
        // then
        assertThat(actual)
            .usingRecursiveComparison()
            .ignoringCollectionOrder()
            .isEqualTo(expected);
    }

    @Test
    void readByUsername() throws PlayerNotFoundException {
        // given
        Player expected = TestDataProvider.ALICE;
        // when
        Player actual = repository.readByUsername(TestDataProvider.ALICE_USERNAME);
        // then
        assertThat(actual)
            .usingRecursiveComparison()
            .isEqualTo(expected);
    }

    @Test
    void readByUsernameShouldThrowPlayerNotFoundExceptionWhenPlayerIsNotInDatabase() {
        // given
        Player expected = TestDataProvider.ALICE;
        // when
        // then
        assertThatThrownBy(()->{
           repository.readByUsername(TestDataProvider.UNKNOWN_USERNAME);
        }).isInstanceOf(PlayerNotFoundException.class);
    }

    @Test
    void save() {
        System.out.println(repository.readAll());
    }

    @Test
    void delete() {
        System.out.println(repository.readAll());
    }

    private static class TestDataProvider{

        private static final String ALICE_USERNAME = "alice";
        private static final int ALICE_INIT_SCORE =1800;
        private static final Player ALICE = new Player(ALICE_USERNAME, ALICE_INIT_SCORE);

        private static final String BOB_USERNAME = "bob";
        private static final int BOB_INIT_SCORE =1820;
        private static final Player BOB = new Player(BOB_USERNAME, BOB_INIT_SCORE);

        private static final String CHARLIE_USERNAME = "charlie";
        private static final int CHARLIE_INIT_SCORE =1793;
        private static final Player CHARLIE = new Player(CHARLIE_USERNAME, CHARLIE_INIT_SCORE);

        private static final String UNKNOWN_USERNAME = "unknown";
    }
}