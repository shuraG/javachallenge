package com.mycompany.javachallenge.bowling;


import com.mycompany.javachallenge.game.Game;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brayme
 */
public class BowlingCalculatorTest {

    /**
     * Test of calculateGame, of class BowlingCalculator.
     */
    @Test
    public void testCalculateGame() {
        System.out.println("calculateGame");

        Game game = new Game();
        game.setPinFalls(Arrays.asList("10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10"));

        Game expResult = new Game();
        expResult.setScore(Arrays.asList(30, 60, 90, 120, 150, 180, 210, 240, 270, 300));

        BowlingCalculator bc = new BowlingCalculator();
        Game result = bc.calculateGame(game);

        assertEquals(expResult.getScore(), result.getScore());

    }

}
