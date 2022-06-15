package com.highfi.entity;

public class Lawn {

    private Coordinate maxPosition;

    public Lawn(Coordinate maxPosition) {
        this.maxPosition = maxPosition;
    }

    public Coordinate getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(Coordinate maxPosition) {
        this.maxPosition = maxPosition;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "maxPosition=" + maxPosition +
                '}';
    }
}
