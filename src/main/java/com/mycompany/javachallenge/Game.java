package com.mycompany.javachallenge;

import com.mycompany.javachallenge.util.RollInvalidException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author brayme
 */
public class Game {

    private int countRoll;
    private int countFrame;
    private int index;
    private int acumulatePoint;
    private List<Integer> points = new ArrayList<>();
    //List<Integer> scores = new ArrayList<>(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
    List<Integer> scores = new ArrayList<>(Arrays.asList(8, 2, 7, 4, 3, 4, 10, 2, 8, 10, 10, 8, 0, 10, 8, 2, 9));

    public void calculate() {
        Rule strikeNon10 = (a, b, c) -> {
            this.countRoll += 2;
            this.countFrame++;
            this.index++;
            acumulatePoint += a + b + c;
        };
        Rule frame10 = (a, b, c) -> {
            this.countRoll += 3;
            this.index++;
            acumulatePoint += a + b + c;
        };

        Rule nonFrame10 = (a, b, c) -> {
            this.countRoll += 2;
            this.countFrame++;
            this.index += 2;
            if (a + b == 10) {
                acumulatePoint += a + b + c;
            }
            if (a + b < 10) {
                acumulatePoint += a + b;
            }

        };

        Validation validation = (a, b) -> {
            if (a < 10) {
                if (a + b > 10 || a + b < 0) {
                    return "Roll error value: Sum of two rolls,in a frame, should be between 0 and";
                }
            }
            return null;
        };

        int roll, nextRoll, nextNextroll;
        try {
            while (index < scores.size() - 2) {
                roll = scores.get(index);
                nextRoll = scores.get(index + 1);
                nextNextroll = scores.get(index + 2);
                String error = validation.run(roll, nextRoll);
                if (error != null) {
                    throw new RollInvalidException(error);
                }

                if (roll == 10 && this.countFrame < 9) {
                    strikeNon10.rule(roll, nextRoll, nextNextroll);
                } else if (this.countFrame == 9) {
                    frame10.rule(roll, nextRoll, nextNextroll);
                } else if (roll < 10 && this.countFrame < 9) {
                    nonFrame10.rule(roll, nextRoll, nextNextroll);
                }

            }
        } catch (RollInvalidException re) {
            System.out.println(re.getMessage());
        }

    }

    public int getCountRoll() {
        return countRoll;
    }

    public int getAcumulatePoint() {
        return acumulatePoint;
    }

}
