/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javachallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brayme
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        game.calculate();

        System.out.println(game.getCountRoll());
        System.out.println("AcumulatePoints: " + game.getAcumulatePoint());

        /* List<Integer> scores = new ArrayList<>(Arrays.asList(7, 43, 2, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
        int totalSpaces = 0;
        int numberFrame = 0;

        for (int i = 0; i < scores.size(); i++) {
            int score = scores.get(i);
            if (numberFrame == 9) {
                totalSpaces++;
            } else if (score == 10) {
                numberFrame++;
                totalSpaces += 2;
            } else if (score != 10) {
                int sumScore = scores.get(i) + scores.get(i + 1);
                if (sumScore > 10 || sumScore < 0) {
                    break;
                } else {
                    numberFrame++;
                    totalSpaces += 2;
                    i++;
                }
            }
        }

        System.out.println(totalSpaces);
        System.out.println(numberFrame);*/
    }
}
