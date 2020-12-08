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
    private static final Map<Integer,Integer> TRIPLE_SCORE_MODIFIERS;

    static {
        TRIPLE_SCORES = new HashMap<>();
        TRIPLE_SCORES.put(1,1000);
        TRIPLE_SCORES.put(2,200);
        TRIPLE_SCORES.put(3,300);
        TRIPLE_SCORES.put(4,400);
        TRIPLE_SCORES.put(5,500);
        TRIPLE_SCORES.put(6,600);

        TRIPLE_SCORE_MODIFIERS = new HashMap<>();
        TRIPLE_SCORE_MODIFIERS.put(3,1);
        TRIPLE_SCORE_MODIFIERS.put(4,2);
        TRIPLE_SCORE_MODIFIERS.put(5,4);
        TRIPLE_SCORE_MODIFIERS.put(6,8);
    }

    public int score(int[] dice) throws IllegalArgumentException{
        int score = 0;
        checkDice(dice);
        int[] diceValueCounts = new int[] {0,0,0, 0,0,0};
        Arrays.stream(dice).forEach(die -> diceValueCounts[die-1]++);
        if(isStraight(diceValueCounts)){
            score += 1200;
            return score;
        }
        if(isThreePairs(diceValueCounts)){
            score += 800;
            return score;
        }
        if(isSingleOne(diceValueCounts)){
            score += 100;
        }
        if(isSingleFive(diceValueCounts)){
            score += 50;
        }
        score += calculateTripleScores(diceValueCounts);
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

    private int calculateTripleScores(int[] diceValueCounts){
        int score = 0;
        for(int index = 0; index < diceValueCounts.length; index++){
            score += TRIPLE_SCORES.get(index+1) * TRIPLE_SCORE_MODIFIERS.getOrDefault(diceValueCounts[index],0);
        }
        return score;
    }

    private boolean isThreePairs(int[] diceValueCounts){
        return Arrays.stream(diceValueCounts).map(diceValueCount -> diceValueCount == 2 ? 1 : 0).reduce(0, Integer::sum) == 3;
    }

    private boolean isStraight(int[] diceValueCounts){
        return Arrays.stream(diceValueCounts)
                .mapToObj(dieValueCount -> dieValueCount == 1)
                .reduce(true, (subtotal, element)-> subtotal && element);
    }

    private boolean isSingleOne(int[] diceValueCounts){
        return diceValueCounts[0] == 1;
    }

    private boolean isSingleFive(int[] diceValueCounts){
        return diceValueCounts[4] == 1;
    }

}
