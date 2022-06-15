package com.highfi.service;

import com.highfi.entity.Coordinate;
import com.highfi.entity.Lawn;
import com.highfi.entity.Mower;
import com.highfi.enums.Orientation;

public class InstructionRunner {

    /**
     * Will be rotate the mower to the right
     *
     * @param mower
     */
    protected static void rotateToRight(Mower mower) {

        switch (mower.getOrientation()) {
            case NORTH:
                mower.setOrientation(Orientation.EAST);
                break;
            case EAST:
                mower.setOrientation(Orientation.SOUTH);
                break;
            case SOUTH:
                mower.setOrientation(Orientation.WEST);
                break;
            case WEST:
                mower.setOrientation(Orientation.NORTH);
                break;
        }
    }

    /**
     * Will be rotate the mower to the left
     *
     * @param mower
     */
    protected static void rotateToLeft(Mower mower) {

        switch (mower.getOrientation()) {
            case NORTH:
                mower.setOrientation(Orientation.WEST);
                break;
            case WEST:
                mower.setOrientation(Orientation.SOUTH);
                break;
            case SOUTH:
                mower.setOrientation(Orientation.EAST);
                break;
            case EAST:
                mower.setOrientation(Orientation.NORTH);
                break;
        }
    }

    /**
     * Parse and run the mower instruction and write the new position and the new orientation in the end
     *
     * @param mower
     * @param lawn
     */
    public static void executeMowerInstruction(Mower mower, Lawn lawn) {

        for (Character order : mower.getInstruction().toCharArray()) {

            switch (order) {
                case 'A':
                    moveMower(mower, lawn);
                    break;
                case 'D':
                    rotateToRight(mower);
                    break;
                case 'G':
                    rotateToLeft(mower);
                    break;
            }
        }
        // in the end the mower will return her position (x,y) and her orientation
        System.out.println(mower.getCoordinate() + " " + mower.getOrientation().getCode());
    }

    /**
     * check the lawn max position(x,y) before move the mower
     * based in the orientation of the mower will increment/decrement X or Y value
     *
     * @param mower
     * @param lawn
     */
    protected static void moveMower(Mower mower, Lawn lawn) {

        switch (mower.getOrientation()) {
            case NORTH:
                if (mower.getCoordinate().getY() + 1 <= lawn.getMaxPosition().getY()) {
                    Coordinate coordinate = mower.getCoordinate();
                    coordinate.setY(coordinate.getY() + 1);
                    mower.setCoordinate(coordinate);
                }
                break;
            case SOUTH:
                if (mower.getCoordinate().getY() - 1 >= 0) {
                    Coordinate coordinate = mower.getCoordinate();
                    coordinate.setY(coordinate.getY() - 1);
                    mower.setCoordinate(coordinate);
                }
                break;
            case EAST:
                if (mower.getCoordinate().getX() + 1 <= lawn.getMaxPosition().getX()) {
                    Coordinate coordinate = mower.getCoordinate();
                    coordinate.setX(coordinate.getX() + 1);
                    mower.setCoordinate(coordinate);
                }
                break;
            case WEST:
                if (mower.getCoordinate().getX() - 1 >= 0) {
                    Coordinate coordinate = mower.getCoordinate();
                    coordinate.setX(coordinate.getX() - 1);
                    mower.setCoordinate(coordinate);
                }
                break;
        }
    }
}
