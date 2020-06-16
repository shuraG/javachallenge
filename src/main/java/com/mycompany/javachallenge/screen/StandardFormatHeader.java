/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javachallenge.screen;

import com.mycompany.javachallenge.domain.Player;
import java.util.List;

/**
 *
 * @author brayme
 */
public class StandardFormatHeader implements Format {

    private int maxLengthFormat = 8;
    private String separator;

    @Override
    public String makeformat(SeparationFormat sf, List<Player> players, int maxLengthFormat) {
        separator = sf.getRepresentation();
        this.maxLengthFormat = maxLengthFormat > this.maxLengthFormat ? maxLengthFormat : this.maxLengthFormat;
        return header();

    }

    private String header() {
        String sepX2 = separator + separator;
        String format = "%-" + maxLengthFormat + "s" + separator + "%d" + sepX2 + "%d" + sepX2 + "%d" + sepX2 + "%d" + sepX2 + "%d" + sepX2 + "%d" + sepX2 + "%d" + sepX2 + "%d" + sepX2 + "%d" + sepX2 + "%d";
        String header = String.format(format, "Frame", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return header;
    }

}
