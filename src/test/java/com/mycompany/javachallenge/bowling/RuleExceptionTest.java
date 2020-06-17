package com.mycompany.javachallenge.bowling;

import com.mycompany.javachallenge.exception.InvalidInputException;
import com.mycompany.javachallenge.exception.RollInvalidException;
import com.mycompany.javachallenge.game.Game;
import java.util.Arrays;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author brayme
 */
public class RuleExceptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throwsInvalidInputExceptionIfIsNotNumberOrF() {
        System.out.println("Exception for invalid inputs");
        Game game = new Game();
        game.setPinFalls(Arrays.asList("F", "A", "C"));

        exception.expect(InvalidInputException.class);
        exception.expectMessage("Input: A is not valid. Your inputs must be: 0 to 9 or F(fouls).");
        BowlingCalculator bc = new BowlingCalculator();
        bc.calculateGame(game);
    }

    @Test
    public void throwsRollInvalidException() {
        System.out.println("Exception for more inputs allowed");
        Game game = new Game();
        game.setPinFalls(Arrays.asList("10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10"));

        exception.expect(RollInvalidException.class);
        exception.expectMessage("Roll error value: You have more rolls than allowed.");
        BowlingCalculator bc = new BowlingCalculator();
        bc.calculateGame(game);
    }

    @Test
    public void throwsRollInvalidExceptionNotHaveExtraRoll() {
        System.out.println("Exception for not extra roll");
        Game game = new Game();
        game.setPinFalls(Arrays.asList("10", "7", "3", "9", "0", "10", "0", "8", "8", "2", "F", "6", "10", "10", "1", "8", "1"));

        exception.expect(RollInvalidException.class);
        exception.expectMessage("Roll error value: You don't have an extra roll in frame 10.");
        BowlingCalculator bc = new BowlingCalculator();
        bc.calculateGame(game);
    }

}
