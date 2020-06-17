package com.mycompany.javachallenge.bowling;

/**
 *
 * @author brayme
 */
public class FactoryRules {

    /**
     *
     * @param gameState it is the base decide which kind of rule, it should run.
     * @return Rule
     */
    public Rule createRule(GameState gameState) {

        Rule rule = null;
        int countFrame = gameState.getCountFrame();
        int puntuation = gameState.getPuntuationRoll();

        if (countFrame == 9) {
            rule = frame10;
        } else if (puntuation == 10 && countFrame < 9) {
            rule = strikeNon10;
        } else if (puntuation < 10 && countFrame < 9) {
            rule = nonFrame10;
        }

        return rule;
    }

    private Rule strikeNon10 = (a, b, c, gameState) -> {
        int pointsFrame = a + b + c;
        int acumulatePoints = gameState.getAcumulatePoint() + pointsFrame;
        gameState.change(2, 1, 1, pointsFrame, acumulatePoints);
        return gameState;
    };

    private Rule nonFrame10 = (a, b, c, gameState) -> {
        int pointsFrame = 0;
        int acumulatePoints;
        if (a + b == 10) {
            gameState.changeFormatPinFalls(gameState.getIndex() + 1, "/");
            pointsFrame = a + b + c;
        }
        if (a + b < 10) {
            pointsFrame = a + b;
        }
        acumulatePoints = gameState.getAcumulatePoint() + pointsFrame;
        gameState.change(2, 1, 2, pointsFrame, acumulatePoints);
        return gameState;
    };

    private Rule frame10 = (a, b, c, gameState) -> {
        int pointsFrame;
        int acumulatePoints;
        if (a + b == 10) {
            gameState.changeFormatPinFalls(gameState.getIndex() + 1, "/");
        } else if (b != 10 && b + c == 10) {
            gameState.changeFormatPinFalls(gameState.getIndex() + 2, "/");
        }
        pointsFrame = a + b + c;
        acumulatePoints = gameState.getAcumulatePoint() + pointsFrame;
        gameState.change(3, 0, 1, pointsFrame, acumulatePoints);
        return gameState;
    };

}
