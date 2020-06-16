package com.mycompany.javachallenge.bowling;

/**
 *
 * @author brayme
 */
public interface Rule {

    GameState run(int score1, int score2, int score3, GameState g);

}
