package com.yatzy.game;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dice {

    List<Integer> diceRollResults;
    private static final List<Integer> SMALL_STRAIGHT = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);

    public Dice(int diceRoll1, int diceRoll2, int diceRoll3, int diceRoll4, int diceRoll5) {
      this.diceRollResults = List.of(diceRoll1, diceRoll2, diceRoll3, diceRoll4, diceRoll5);
    }

    public int sum(){
        return diceRollResults.stream().reduce(0,Integer::sum);
    }
    /**
     *  Classify all dice rolls results based on each roll dice and their occurence
     *
     * @return each roll dice with its occurence
     */
    public Map<Integer, Long> countAndGroupDiceSides() {
        return diceRollResults.stream()
                .collect(Collectors.groupingBy(
                         Function.identity(), 
                         Collectors.counting()
                ));
    }
    /**
     * Count dice roll occurrences
     *
     * @param sideNumber
     * @return the number of occurrences for a specific side number
     */
    public int countDiceSide(int sideNumber) {
        return countAndGroupDiceSides().getOrDefault(sideNumber, Long.valueOf(0)).intValue();
    }

    /**
     *  Get dice rolls where their occurence is equal to the given param
     *
     * @return the sum of the coressponding dice rolls
     */
    public Stream<Integer> getDiceRollsWithOccurenceEqualTo(int sideNumber) {
        return  countAndGroupDiceSides().entrySet().
                stream().filter(sideRoll -> sideRoll.getValue() == sideNumber)
                .map(Map.Entry::getKey);
    }

    /**
     *
     *  Get dice rolls where their occurence is gretaer than the given param
     *
     * @param sideNumber
     * @return the sum of the coressponding dice rolls
     */
    public Stream<Integer> getDiceRollsWithOccurenceGreaterThan(int sideNumber) {
        return  countAndGroupDiceSides().entrySet().
                stream().filter(sideRoll -> sideRoll.getValue() >= sideNumber)
                .map(Map.Entry::getKey);
    }

    /**
     * Checks if the roll is compatible with the category Yatzy
     *
     * @return true if Yatzy, false otherwise.
     */
    public boolean isYatzy() {
        return (getDiceRollsWithOccurenceGreaterThan(5).reduce(0,Integer::sum))!=0;

    }

    /**
     * Checks if there is at least two pairs
     *
     * @return true if Two Pair, false otherwise.
     */
    public boolean isTwoPair() {
        return (getDiceRollsWithOccurenceGreaterThan(2).collect(Collectors.toList()).size()==2);

    }

    /**
     * Checks if the roll is compatible with the category Small Straight
     *
     * @return true if Small Straight, false otherwise.
     */
    public boolean isSmallStraight() {
        return diceRollResults.stream()
                .sorted()
                .collect(Collectors.toList())
                .equals(SMALL_STRAIGHT);
    }

    /**
     * Checks if the roll is compatible with the category Large Straight
     *
     * @return true if full house, false otherwise.
     */
    public boolean isLargeStraight() {
        return diceRollResults.stream()
                .sorted()
                .collect(Collectors.toList())
                .equals(LARGE_STRAIGHT);
    }

    /**
     * Checks if the roll is compatible with the category Full House
     *
     * @return true if full house, false otherwise.
     */
    public boolean isFullHouse() {
        int threeOfKind = getDiceRollsWithOccurenceEqualTo(3)
                .reduce(0, Integer::sum);
        int pair = getDiceRollsWithOccurenceEqualTo(2)
                .reduce(0, Integer::sum);
       return (pair != 0 && threeOfKind != 0) ;


    }

}
