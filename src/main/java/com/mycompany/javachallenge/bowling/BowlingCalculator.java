package com.mycompany.javachallenge.bowling;

import com.mycompany.javachallenge.exception.Validation;
import com.mycompany.javachallenge.game.Game;

/**
 *
 * @author brayme
 */
public class BowlingCalculator {

    public Game calculateGame(Game game) {
        GameState initialGameState = new GameState(game.getPinFalls());
        GameState finalGameState = calculateScore(initialGameState);
        Game g = new Game();
        g.setPinFalls(finalGameState.getPinfalls());
        g.setScore(finalGameState.getPoints());
        return g;
    }

    /**
     * Calculate the results of the rolls, based on a game state, which is
     * updated, as the rules run.
     *
     * @param gameState provide an initial state of the game.
     * @return final state fame.
     *
     */
    private GameState calculateScore(GameState gameState) {

        int roll, nextRoll, nextNextroll, index;
        FactoryRules factoryRules = new FactoryRules();
        while (gameState.getIndex() < gameState.getPinfalls().size() - 2) {
            index = gameState.getIndex();

            roll = parsePuntuation(gameState.getPinfalls().get(index));
            nextRoll = parsePuntuation(gameState.getPinfalls().get(index + 1));
            nextNextroll = parsePuntuation(gameState.getPinfalls().get(index + 2));
            Validation.pointsFrame(roll, nextRoll, nextNextroll, gameState);

            gameState.setPuntuationRoll(roll);

            Rule rule = factoryRules.createRule(gameState);
            gameState = rule.run(roll, nextRoll, nextNextroll, gameState);

        }

        Validation.totalRolls(gameState);
        return gameState;
    }

    /**
     * Convert and validate a puntuation.
     */
    private int parsePuntuation(String puntuation) {
        Validation.input(puntuation);
        return puntuation.equals("F") ? 0 : Integer.valueOf(puntuation);
    }

}
