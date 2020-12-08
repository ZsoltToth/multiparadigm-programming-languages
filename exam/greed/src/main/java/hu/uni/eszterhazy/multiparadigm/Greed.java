package hu.uni.eszterhazy.multiparadigm;

import java.util.Arrays;

public class Greed {


    public int score(int[] dice) throws IllegalArgumentException{
        if(dice.length < 1 || dice.length > 6){
            throw new IllegalArgumentException();
        }
        Arrays.stream(dice).forEach(die -> {
            if((die < 1) || (die > 6)){
                throw new IllegalArgumentException();
            }
        });
        return 0;
    }



}
