package com.highfi.enums;

import java.util.Arrays;

public enum Orientation {

    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private String code;

    Orientation(String code) {
        this.code = code;
    }

    /**
     * based in the input code (N,E,S,W) will return the orientation enum
     *
     * @param code
     * @return
     */
    public static Orientation getOrientationByCode(String code) {
        return Arrays.stream(Orientation.values())
                .filter(orientation -> orientation.getCode().equals(code))
                .findFirst().orElse(null);
    }

    public String getCode() {
        return code;
    }
}
