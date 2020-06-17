package com.mycompany.javachallenge.screen;


import com.mycompany.javachallenge.game.Player;
import java.util.List;

/**
 *
 * @author brayme
 */
public abstract class Screen {

    Format format;

    String textFormatted;

    public abstract void display();

    public void performFormat(SeparationFormat sf, List<Player> players) {
        int maxLengthFormat = maxLengthFormat(players);
        textFormatted = format.makeformat(sf, players, maxLengthFormat);
    }

    private int maxLengthFormat(List<Player> players) {
        return players.stream()
                .map(p -> p.getName().length())
                .max(Integer::compare)
                .get();
    }

    public void setFormat(Format format) {
        this.format = format;
    }

}
