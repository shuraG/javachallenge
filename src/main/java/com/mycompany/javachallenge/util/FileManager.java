package com.mycompany.javachallenge.util;

import com.mycompany.javachallenge.domain.Game;
import com.mycompany.javachallenge.domain.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author brayme
 */
public class FileManager {

    public static List<Player> listInputs(String path) {

        Map<String, List<String>> map = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                map.putIfAbsent(split[0], new LinkedList<>());
                map.computeIfPresent(split[0], (key, prev) -> {
                    prev.add(split[1]);
                    return prev;
                });
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return toPlayers(map);
    }

    private static List<Player> toPlayers(Map<String, List<String>> map) {

        List<Player> players = new LinkedList<>();

        map.forEach((k, v) -> {
            Player p = new Player();
            p.setName(k);

            Game g = new Game();
            g.setPinFalls(v);

            p.setGame(g);
            players.add(p);
        });
        return players;
    }

}
