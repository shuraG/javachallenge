/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javachallenge.screen;

/**
 *
 * @author brayme
 */
public class ConsoleScreen extends Screen {

    public ConsoleScreen() {
        format = new StandardFormatHeader();
    }

    @Override
    public void display() {
        System.out.println(textFormatted);
    }

}
