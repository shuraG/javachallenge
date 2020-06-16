package com.mycompany.javachallenge.screen;

import com.mycompany.javachallenge.domain.Player;
import java.util.List;

/**
 *
 * @author brayme
 */
public class StandardFormatPlayer implements Format {

    private int maxLengthFormat = 8;
    private String separator;

    @Override
    public String makeformat(SeparationFormat sf, List<Player> players, int maxLengthFormat) {
        separator = sf.getRepresentation();
        this.maxLengthFormat = maxLengthFormat > this.maxLengthFormat ? maxLengthFormat : this.maxLengthFormat;
        return players.stream().map(t -> pinfalls(t) + score(t)).reduce("", String::concat);
    }

    private String score(Player player) {

        String format = "\n%-" + maxLengthFormat + "s" + separator;
        String score = String.format(format, "Score");

        score += player.getGame().getScore().stream().map(p -> {
            return String.format("%s" + separator + separator, p);
        }).reduce("", String::concat);

        return score;
    }

    private String pinfalls(Player player) {

        String format = "\n%s\n%-" + maxLengthFormat + "s" + separator;
        String textFormatted = String.format(format, player.getName(), "Pinfalls");
        List<String> pinFalls = player.getGame().getPinFalls();

        textFormatted += pinFalls.subList(0, pinFalls.size() - 3).stream()
                .map(p -> p.equals("10") ? String.format(separator + "%s" + separator, "X") : String.format("%s" + separator, p))
                .reduce("", String::concat);

        textFormatted += pinFalls.subList(pinFalls.size() - 3, pinFalls.size()).stream()
                .map(p -> String.format("%s" + separator, p.equals("10") ? "X" : p))
                .reduce("", String::concat);

        return textFormatted;
    }

}
