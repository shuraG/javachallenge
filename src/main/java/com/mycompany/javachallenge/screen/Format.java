package com.mycompany.javachallenge.screen;

import com.mycompany.javachallenge.domain.Player;
import java.util.List;

/**
 *
 * @author brayme
 */
public interface Format {

    public String makeformat(SeparationFormat sf, List<Player> playerList, int maxLengthFormat);
}
