package com.mycompany.javachallenge.bowling;

import com.mycompany.javachallenge.domain.Game;
import com.mycompany.javachallenge.exception.Validation;

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

    private int parsePuntuation(String puntuation) {
        Validation.input(puntuation);
        return puntuation.equals("F") ? 0 : Integer.valueOf(puntuation);
    }

}
