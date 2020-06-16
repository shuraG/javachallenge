package com.mycompany.javachallenge.screen;

/**
 *
 * @author brayme
 */
public enum SeparationFormat {
    TAB("\t"), FOURSPACES("    ");

    private final String representation;

    SeparationFormat(String re) {
        representation = re;
    }

    public String getRepresentation() {
        return representation;
    }

}
