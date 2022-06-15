package com.highfi.entity;

import com.highfi.enums.Orientation;

public class Mower {

    private Coordinate coordinate;

    private Orientation orientation;

    private String instruction;


    public Mower(Coordinate coordinate, Orientation orientation, String instruction) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.instruction = instruction;
    }

    public Mower(Coordinate coordinate, String orientation, String instruction) {
        this.coordinate = coordinate;
        this.instruction = instruction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }


}
