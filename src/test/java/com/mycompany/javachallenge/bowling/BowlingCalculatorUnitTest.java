/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javachallenge.bowling;

import com.mycompany.javachallenge.game.Game;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author brayme
 */
public class BowlingCalculatorUnitTest {

    public BowlingCalculatorUnitTest() {
    }

    @Test
    public void testCalculatePerfectGame() {
        System.out.println("Calculate perfect game");

        Game game = new Game();
        game.setPinFalls(Arrays.asList("10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10"));

        Game expResult = new Game();
        expResult.setScore(Arrays.asList(30, 60, 90, 120, 150, 180, 210, 240, 270, 300));

        BowlingCalculator bc = new BowlingCalculator();
        Game result = bc.calculateGame(game);

        assertEquals(expResult.getScore(), result.getScore());
    }

    @Test
    public void testCalculateZeroScore() {
        System.out.println("Calculate zero score game");

        Game game = new Game();
        game.setPinFalls(Arrays.asList("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"));

        Game expResult = new Game();
        expResult.setScore(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        BowlingCalculator bc = new BowlingCalculator();
        Game result = bc.calculateGame(game);

        assertEquals(expResult.getScore(), result.getScore());

    }

    @Test
    public void testCalculateJeffScore() {
        System.out.println("Calculate Jeff score game");

        Game game = new Game();
        game.setPinFalls(Arrays.asList("10", "7", "3", "9", "0", "10", "0", "8", "8", "2", "F", "6", "10", "10", "10", "8", "1"));

        Game expResult = new Game();
        expResult.setScore(Arrays.asList(20, 39, 48, 66, 74, 84, 90, 120, 148, 167));

        BowlingCalculator bc = new BowlingCalculator();
        Game result = bc.calculateGame(game);

        assertEquals(expResult.getScore(), result.getScore());

    }

    @Test
    public void testCalculateJohnScore() {
        System.out.println("Calculate John score game");

        Game game = new Game();
        game.setPinFalls(Arrays.asList("3", "7", "6", "3", "10", "8", "1", "10", "10", "9", "0", "7", "3", "4", "4", "10", "9", "0"));

        Game expResult = new Game();
        expResult.setScore(Arrays.asList(16, 25, 44, 53, 82, 101, 110, 124, 132, 151));

        BowlingCalculator bc = new BowlingCalculator();
        Game result = bc.calculateGame(game);

        assertEquals(expResult.getScore(), result.getScore());

    }
}
