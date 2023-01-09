import com.yatzy.game.Dice;
import com.yatzy.game.ScoreCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreCalculatorTest {


    @Test
    public void testChance() {
        assertEquals(14, ScoreCalculator.getChanceScore(new Dice(1, 1, 3, 3, 6)));
        assertEquals(21, ScoreCalculator.getChanceScore(new Dice(4, 5, 5, 6, 1)));
    }

    @Test
    public void testYatzy() {
        assertEquals(50, ScoreCalculator.getYatzyScore(new Dice(1, 1, 1, 1, 1)));
        assertEquals(0, ScoreCalculator.getYatzyScore(new Dice(1, 1, 1, 2, 1)));
    }

    @Test
    public void testOnes() {
        assertEquals(1, ScoreCalculator.getOnesScore(new Dice(1, 4, 2, 4, 4)));
        assertEquals(3, ScoreCalculator.getOnesScore(new Dice(2, 2, 1, 1, 1)));
        assertEquals(0, ScoreCalculator.getOnesScore(new Dice(6, 6, 2, 4, 3)));
    }

    @Test
    public void testTwos() {
        assertEquals(0, ScoreCalculator.getTwosScore(new Dice(1, 1, 3, 4, 5)));
        assertEquals(2, ScoreCalculator.getTwosScore(new Dice(1, 5, 1, 2, 5)));
        assertEquals(6, ScoreCalculator.getTwosScore(new Dice(2, 2, 2, 4, 5)));

    }

    @Test
    public void testThrees() {
        assertEquals(9, ScoreCalculator.getThreesScore(new Dice(1, 3, 3, 3, 5)));
        assertEquals(0, ScoreCalculator.getThreesScore(new Dice(1, 6, 2, 4, 5)));
        assertEquals(3, ScoreCalculator.getThreesScore(new Dice(6, 5, 2, 1, 3)));

    }

    @Test
    public void testFours() {
        assertEquals(8, ScoreCalculator.getFoursScore(new Dice(4, 6, 3, 4, 2)));
        assertEquals(4, ScoreCalculator.getFoursScore(new Dice(2, 2, 3, 4, 5)));
        assertEquals(0, ScoreCalculator.getFoursScore(new Dice(5, 5, 2, 1, 5)));

    }

    @Test
    public void testFives() {
        assertEquals(10, ScoreCalculator.getFivesScore(new Dice(6, 2, 4, 5, 5)));
        assertEquals(5, ScoreCalculator.getFivesScore(new Dice(2, 1, 1, 6, 5)));
        assertEquals(25, ScoreCalculator.getFivesScore(new Dice(5, 5, 5, 5, 5)));
    }

    @Test
    public void testSixes() {
        assertEquals(6, ScoreCalculator.getSixesScore(new Dice(1, 2, 6, 4, 5)));
        assertEquals(18, ScoreCalculator.getSixesScore(new Dice(6, 2, 6, 6, 3)));
        assertEquals(12, ScoreCalculator.getSixesScore(new Dice(6, 2, 4, 1, 6)));
    }

    @Test
    public void testOnePair() {
        assertEquals(0, ScoreCalculator.getOnePairScore(new Dice(1, 2, 3,4, 5)));
        assertEquals(8, ScoreCalculator.getOnePairScore(new Dice(3, 3, 3, 4, 4)));
        assertEquals(12, ScoreCalculator.getOnePairScore(new Dice(1, 1, 6, 2, 6)));
        assertEquals(6, ScoreCalculator.getOnePairScore(new Dice(3, 3, 3, 4, 1)));
        assertEquals(6, ScoreCalculator.getOnePairScore(new Dice(3, 3, 3, 3, 1)));
    }

    @Test
    public void testTwoPairs() {
        assertEquals(8, ScoreCalculator.getTwoPairsScore(new Dice(1, 1, 2, 3, 3)));
        assertEquals(6, ScoreCalculator.getTwoPairsScore(new Dice(1, 1, 2, 2, 2)));
        assertEquals(0, ScoreCalculator.getTwoPairsScore(new Dice(3, 3, 3, 3, 1)));
        assertEquals(0, ScoreCalculator.getTwoPairsScore(new Dice(3, 3, 3, 2, 1)));
    }

    @Test
    public void testThreeOfAKind() {
        assertEquals(9, ScoreCalculator.getThreeOfKindScore(new Dice(3, 3, 3, 4, 5)));
        assertEquals(0, ScoreCalculator.getThreeOfKindScore(new Dice(3, 3, 4, 5, 6)));
        assertEquals(9, ScoreCalculator.getThreeOfKindScore(new Dice(3, 3, 3, 3, 1)));
    }

    @Test
    public void testFourOfAKind() {
        assertEquals(8, ScoreCalculator.getFourOfKindScore(new Dice(2, 2, 2, 2, 5)));
        assertEquals(0, ScoreCalculator.getFourOfKindScore(new Dice(2, 2, 2, 5, 5)));
        assertEquals(8, ScoreCalculator.getFourOfKindScore(new Dice(2, 2, 2, 2, 2)));
    }

    @Test
    public void testSmallStraight() {
        assertEquals(15, ScoreCalculator.getSmallStraightScore(new Dice(1, 2, 3, 4, 5)));
        assertEquals(0, ScoreCalculator.getSmallStraightScore(new Dice(1, 4, 6, 4, 5)));
        assertEquals(15, ScoreCalculator.getSmallStraightScore(new Dice(4, 3, 2, 5, 1)));

    }

    @Test
    public void testLargeStraight() {
        assertEquals(20, ScoreCalculator.getLargeStraightScore(new Dice(4, 2, 3, 6, 5)));
        assertEquals(0, ScoreCalculator.getLargeStraightScore(new Dice(3, 2, 1, 4, 5)));
        assertEquals(20, ScoreCalculator.getLargeStraightScore(new Dice(2, 3, 4, 5, 6)));

    }


    @Test
    public void testFullHouse() {
        assertEquals(8, ScoreCalculator.getFullHouseScore(new Dice(1, 1, 2, 2, 2 )));
        assertEquals(0, ScoreCalculator.getFullHouseScore(new Dice(2, 2, 3, 3, 4 )));
        assertEquals(0, ScoreCalculator.getFullHouseScore(new Dice(4, 4, 4, 4, 4)));
    }

}


