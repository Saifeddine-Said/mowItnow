package com.highfi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoordinateTest {

    @Test
    void should_return_true_when_two_object_equals() {

        Coordinate coordinate = new Coordinate(1, 2);

        Coordinate coordinate2 = new Coordinate(1, 2);

        assertEquals(coordinate.equals(coordinate2),true);
    }

    @Test
    void should_return_false_when_two_object_equals() {

        Coordinate coordinate = new Coordinate(1, 2);

        Coordinate coordinate2 = new Coordinate(1, 0);

        assertEquals(coordinate.equals(coordinate2),false);
    }

}