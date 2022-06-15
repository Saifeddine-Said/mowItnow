package com.highfi.service;

import com.highfi.entity.Coordinate;
import com.highfi.entity.Lawn;
import com.highfi.entity.Mower;
import com.highfi.enums.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionRunnerTest {
    private Mower mower;

    @BeforeEach
    void init() {
        mower = new Mower(new Coordinate(1, 2), Orientation.NORTH, "GAGAGAGAA");

    }


    @Test
    void should_return_east_when_orientation_is_north_and_rotation_is_right() {
        InstructionRunner.rotateToRight(mower);
        assertEquals(Orientation.EAST, mower.getOrientation());
    }

    @Test
    void should_return_west_when_orientation_is_north_and_rotation_is_left() {
        InstructionRunner.rotateToLeft(mower);
        assertEquals(Orientation.WEST, mower.getOrientation());
    }

    @Test
    void should_move_to_north() {
        Lawn lawn = new Lawn(new Coordinate(5, 5));
        InstructionRunner.moveMower(mower, lawn);
        assertEquals(3, mower.getCoordinate().getY() );
        assertEquals(1, mower.getCoordinate().getX() );

    }

    @Test
    void should_not_move_when_lawn_surface_is_exceeded() {
        Lawn lawn = new Lawn(new Coordinate(2, 2));
        InstructionRunner.moveMower(mower, lawn);
        assertEquals(2, mower.getCoordinate().getY() );
        assertEquals(1, mower.getCoordinate().getX() );

    }


}