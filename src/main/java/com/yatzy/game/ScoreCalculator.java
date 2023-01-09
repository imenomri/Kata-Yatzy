package com.yatzy.game;

import java.util.Comparator;


/**
 * Score Calculator represents the calculator of yatzy game scores given roll dice results
 */
public class ScoreCalculator {

    /**
     * Get chance's category score
     *
     * @param dice
     * @return the score
     */
   public static int getChanceScore(Dice dice) {
       return dice.diceRollResults.stream()
               .reduce(0, Integer::sum);
    }

    /**
     * Get Yatzy's category score
     *
     * @param dice
     * @return the score
     */
    public static int getYatzyScore(Dice dice) {
        return dice.isYatzy() ? 50 : 0 ;
    }

    /**
     * Get one's category score
     *
     * @param dice
     * @return the score
     */
    public static int getOnesScore(Dice dice) {
       return dice.countDiceSide(1);
   }

    /**
     * Get two's category score
     *
     * @param dice
     * @return the score
     */
    public static int getTwosScore(Dice dice) {
        return 2 * (dice.countDiceSide(2));
    }

    /**
     * Get three's category score
     *
     * @param dice
     * @return the score
     */
    public static int getThreesScore(Dice dice) {
        return 3 * (dice.countDiceSide(3));
    }

    /**
     * Get four's category score
     *
     * @param dice
     * @return the score
     */
    public static int getFoursScore(Dice dice) {
        return 4 *(dice.countDiceSide(4));
    }

    /**
     * Get five's category score
     *
     * @param dice
     * @return the score
     */
    public static int getFivesScore(Dice dice) {
        return 5 * (dice.countDiceSide(5));
    }

    /**
     * Get six's category score
     *
     * @param dice
     * @return the score
     */
    public static int getSixesScore(Dice dice) {
        return 6 * (dice.countDiceSide(6));
    }

    /**
     * Get one pair's category score
     *
     * @param dice
     * @return the score
     */
   public static int getOnePairScore(Dice dice) {

       return 2 * (dice.getDiceRollsWithOccurenceGreaterThan(2)
               .max(Comparator.naturalOrder()).orElse(0));

   }

    /**
     * Get two pair's category score
     *
     * @param dice
     * @return the score
     */
    public static int getTwoPairsScore(Dice dice) {

        return dice.isTwoPair() ? 2 * (dice.getDiceRollsWithOccurenceEqualTo(2).reduce(0,Integer::sum)
                + dice.getDiceRollsWithOccurenceEqualTo(3).reduce(0,Integer::sum)) : 0;
    }

    /**
     * Get threeOfKind's category score
     *
     * @param dice
     * @return the score
     */
    public static int getThreeOfKindScore(Dice dice) {
       return 3 * (dice.getDiceRollsWithOccurenceGreaterThan(3).reduce(0,Integer::sum));
    }

    /**
     * Get fourOfKind's category score
     *
     * @param dice
     * @return the score
     */
    public static int getFourOfKindScore(Dice dice) {
       return 4 * (dice.getDiceRollsWithOccurenceGreaterThan(4).reduce(0,Integer::sum));
    }

    /**
     * Get Small Straight's category score
     *
     * @param dice
     * @return the score
     */
    public static int getSmallStraightScore(Dice dice) {
        return dice.isSmallStraight() ? 15 : 0;
    }

    /**
     * Get Large Straight's category score
     *
     * @param dice roll results
     * @return the score
     */
    public static int getLargeStraightScore(Dice dice) {
        return dice.isLargeStraight() ? 20 : 0;
    }

    /**
     * Get Full House's category score
     *
     * @param dice
     * @return the score
     */
    public static int getFullHouseScore(Dice dice) {
       return dice.isFullHouse() ? dice.sum() : 0;
    }
}
