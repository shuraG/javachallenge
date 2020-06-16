package com.mycompany.javachallenge.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brayme
 */
public class GameState {

    private int countRoll;
    private int countFrame;
    private int index;
    private int acumulatePoint;
    private int puntuationRoll;
    private List<Integer> points;
    private List<String> pinfalls;

    public GameState(List<String> pinfalls) {
        this.points = new ArrayList();
        this.pinfalls = pinfalls;
    }

    public GameState() {
    }
    

    public void change(int countRoll, int countFrame, int index, int pointsFrame, int acumulatePoint) {
        this.countRoll += countRoll;
        this.countFrame += countFrame;
        this.index += index;
        this.acumulatePoint += pointsFrame;
        this.points.add(acumulatePoint);
    }

    public void changeFormatPinFalls(int index, String newFormatPoint) {
        this.pinfalls.set(index, newFormatPoint);

    }

    public int getCountRoll() {
        return countRoll;
    }

    public void setCountRoll(int countRoll) {
        this.countRoll = countRoll;
    }

    public int getCountFrame() {
        return countFrame;
    }

    public void setCountFrame(int countFrame) {
        this.countFrame = countFrame;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getAcumulatePoint() {
        return acumulatePoint;
    }

    public void setAcumulatePoint(int acumulatePoint) {
        this.acumulatePoint = acumulatePoint;
    }

    public int getPuntuationRoll() {
        return puntuationRoll;
    }

    public void setPuntuationRoll(int puntuationRoll) {
        this.puntuationRoll = puntuationRoll;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public List<String> getPinfalls() {
        return pinfalls;
    }

    public void setPinfalls(List<String> pinfalls) {
        this.pinfalls = pinfalls;
    }

}
