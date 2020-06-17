package com.mycompany.javachallenge.game;

import java.util.List;

/**
 *
 * @author brayme
 */
public class Game {

    private List<String> pinFalls;
    private List<Integer> score;

    public List<String> getPinFalls() {
        return pinFalls;
    }

    public void setPinFalls(List<String> pinFalls) {
        this.pinFalls = pinFalls;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

}
