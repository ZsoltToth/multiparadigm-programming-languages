package hu.uni.eszterhazy.multiparadigm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreedTest {

    private Greed greed;

    @BeforeEach
    void setUp() {
        greed = new Greed();
    }

    @Test
    void shouldThrowExceptionIfThereAreMoreThanSixDice(){
       //given
       int[] dice = new int[] {1,2,3,4,5,6,7};
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            greed.score(dice);
        });
    }

    @Test
    void shouldThrowExceptionIfThereIsNoDice(){
        //given
        int[] dice = new int[] {};
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            greed.score(dice);
        });
    }


    @Test
    void shouldThrowExceptionIfAValueIsOutofUpperBound(){
        //given
        int[] dice = new int[] {7};
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            greed.score(dice);
        });
    }

    @Test
    void shouldThrowExceptionIfAValueIsOutofLowerBound(){
        //given
        int[] dice = new int[] {0};
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            greed.score(dice);
        });
    }
}