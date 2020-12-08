package hu.uni.eszterhazy.multiparadigm;

import java.util.Arrays;

public class Greed {

    private static final int MINIMUM_DICE_COUNT = 1;
    private static final int MAXIMUM_DICE_COUNT = 6;
    private static final int MINIMUM_DICE_VALUE = 1;
    private static final int MAXIMUM_DICE_VALUE = 6;

    public int score(int[] dice) throws IllegalArgumentException{
        checkDice(dice);
        return 0;
    }

    private void checkDice(int[] dice) throws  IllegalArgumentException{
        if(dice.length < MINIMUM_DICE_COUNT || dice.length > MAXIMUM_DICE_COUNT){
            throw new IllegalArgumentException();
        }
        Arrays.stream(dice).forEach(die -> {
            if((die < MINIMUM_DICE_VALUE) || (die > MAXIMUM_DICE_VALUE)){
                throw new IllegalArgumentException();
            }
        });
    }


}
