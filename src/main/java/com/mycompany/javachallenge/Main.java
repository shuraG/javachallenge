
package com.mycompany.javachallenge;

import com.mycompany.javachallenge.bowling.BowlingCalculator;
import com.mycompany.javachallenge.game.Player;
import com.mycompany.javachallenge.screen.ConsoleScreen;
import com.mycompany.javachallenge.screen.Screen;
import com.mycompany.javachallenge.screen.SeparationFormat;
import com.mycompany.javachallenge.screen.StandardFormatPlayer;
import com.mycompany.javachallenge.util.FileManager;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author brayme
 */
public class Main {

    public static void main(String[] args) {

        List<Player> players = FileManager.listInputs(args[0]);

        players = players.stream().map(p -> {
            BowlingCalculator bc = new BowlingCalculator();
            p.setGame(bc.calculateGame(p.getGame()));
            return p;
        }).collect(Collectors.toList());

        Screen screen = new ConsoleScreen();
        screen.performFormat(SeparationFormat.TAB, players);
        screen.display();
        screen.setFormat(new StandardFormatPlayer());
        screen.performFormat(SeparationFormat.TAB, players);
        screen.display();

    }
}
