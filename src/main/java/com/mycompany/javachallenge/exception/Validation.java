package com.mycompany.javachallenge.exception;

import com.mycompany.javachallenge.bowling.GameState;

/**
 *
 * @author brayme
 */
public class Validation {

    /**
     * Validate the format puntuation roll.
     *
     * @param puntuation it must be: 1-10 or F
     */
    public static void input(String puntuation) {
        if (!puntuation.matches("\\b([0-9]|10|F)\\b")) {
            throw new InvalidInputException("Input: " + puntuation + " is not valid. Your inputs must be: 0 to 9 or F(fouls).");
        }
    }

    /**
     * Validate of correct values in a frame and special Frame10.
     *
     * @param a value of roll one in a Frame.
     * @param b value of roll two in a Frame.
     * @param c extra roll for a Frame10.
     * @param gameState currente game state.
     */
    public static void pointsFrame(int a, int b, int c, GameState gameState) {
        int numberFrame = gameState.getCountFrame();

        if (a < 10) {
            if (a + b > 10) {
                throw new RollInvalidException("Roll error value: Sum of two rolls,in a frame, should be between 0 and 10.");
            }

            if (numberFrame == 9 && a + b < 10 && c != 0) {
                throw new RollInvalidException("Roll error value: You don't have an extra roll in frame 10.");
            }
        }

        if (numberFrame == 9 && b < 10 && b + c > 10 && a + b != 10) {
            throw new RollInvalidException("Roll error value: Sum of last two rolls in frame10, should be between 0 and 10.");
        }

    }

    public static void totalRolls(GameState gameState) {
        int numberOfRolls = gameState.getCountRoll();
        if (numberOfRolls > 21) {
            throw new RollInvalidException("Roll error value: You have more rolls than allowed.");
        } else if (numberOfRolls < 21) {
            throw new RollInvalidException("Roll error value: You have less rolls than allowed.");
        }

    }

}
