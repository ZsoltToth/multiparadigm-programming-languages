package hu.uni.ekcu.java.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void playerShouldReturnWithInitialScoreIfItWasNotModifiedYet(){
        // given
        Player player = new Player("alice", 42);
        final int expected = 42;
        // when
        final int actual = player.getScore();
        // then
       assertThat(actual).isEqualTo(expected);
    }

    @Test
    void playerShouldReturnWithItsName(){
        // given
        Player player = new Player("alice", 42);
        final String expected = "alice";
        // when
        final String actual = player.getName();
        // then
        assertThat(actual).isEqualTo(expected);
    }
}