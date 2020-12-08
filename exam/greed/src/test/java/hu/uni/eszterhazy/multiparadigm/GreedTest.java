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

    @Test
    void testThreePairs(){
        //given
        int[] dice = new int[] {1,1,2,2,3,3};
        int expected = 800;
        //when
        int actual = greed.score(dice);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testStraight(){
        //given
        int[] dice = new int[] {1,2,3,4,5,6};
        int expected = 1200;
        //when
        int actual = greed.score(dice);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testTripleWithoutModifier(){
        //given
        int[] dice = new int[] {1,1,1,2,2,3};
        int expected = 1000;
        //when
        int actual = greed.score(dice);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testTripleWithDoubleModifier(){
        //given
        int[] dice = new int[] {1,1,1,1,2,3};
        int expected = 2000;
        //when
        int actual = greed.score(dice);
        //then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void testTripleWithFourTimesModifier(){
        //given
        int[] dice = new int[] {1,1,1,1,1,3};
        int expected = 4000;
        //when
        int actual = greed.score(dice);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testTripleWithEightTimesModifier(){
        //given
        int[] dice = new int[] {1,1,1,1,1,1};
        int expected = 8000;
        //when
        int actual = greed.score(dice);
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testTripleTwice(){
        //given
        int[] dice = new int[] {1,1,1,2,2,2};
        int expected = 1000 + 200;
        //when
        int actual = greed.score(dice);
        //then
        Assertions.assertEquals(expected,actual);

    }

}