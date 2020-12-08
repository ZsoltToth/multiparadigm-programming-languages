package hu.uni.eszterhazy.multiparadigm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Greed {

    private static final int MINIMUM_DICE_COUNT = 1;
    private static final int MAXIMUM_DICE_COUNT = 6;
    private static final int MINIMUM_DICE_VALUE = 1;
    private static final int MAXIMUM_DICE_VALUE = 6;

    private static final Map<Integer,Integer> TRIPLE_SCORES;

    static {
        TRIPLE_SCORES = new HashMap<>();
        TRIPLE_SCORES.put(1,1000);
        TRIPLE_SCORES.put(2,200);
        TRIPLE_SCORES.put(3,300);
        TRIPLE_SCORES.put(4,400);
        TRIPLE_SCORES.put(5,500);
        TRIPLE_SCORES.put(6,600);
    }

    public int score(int[] dice) throws IllegalArgumentException{
        int score = 0;
        checkDice(dice);
        int[] diceValueCounts = new int[] {0,0,0, 0,0,0};
        Arrays.stream(dice).forEach(die -> diceValueCounts[die-1]++);
        if(Arrays.stream(diceValueCounts)
                .mapToObj(dieValueCount -> dieValueCount == 1)
                .reduce(true, (subtotal, element)-> subtotal && element)){
            score += 1200;
            return score;
        }
        if(Arrays.stream(diceValueCounts).map(diceValueCount -> diceValueCount == 2 ? 1 : 0).reduce(0, Integer::sum) == 3){
            score += 800;
            return score;
        }
        for(int index = 0; index < diceValueCounts.length; index++){
            if(diceValueCounts[index] < 3) continue;
            if(diceValueCounts[index] == 3){
                score += TRIPLE_SCORES.get(index+1);
            }
            if(diceValueCounts[index] == 4){
                score += TRIPLE_SCORES.get(index+1) * 2;
            }
            if(diceValueCounts[index] == 5){
                score += TRIPLE_SCORES.get(index+1) * 4;
            }
            if(diceValueCounts[index] == 6){
                score += TRIPLE_SCORES.get(index+1) * 8;
            }
        }
        if(diceValueCounts[0] == 1){
            score += 100;
        }
        if(diceValueCounts[4] == 1){
            score += 100;
        }
        return score;
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
