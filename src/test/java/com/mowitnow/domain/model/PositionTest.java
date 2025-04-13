package com.mowitnow.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

    private final Lawn lawn = new Lawn(5, 5);

    @Test
    void shouldMoveForwardNorth() {
        Position start = new Position(1, 2, Orientation.N);
        Position result = start.moveForward(lawn);
        assertEquals(new Position(1, 3, Orientation.N), result);
    }

    @Test
    void shouldNotMoveOutsideLawn() {
        Position start = new Position(5, 5, Orientation.N);
        Position result = start.moveForward(lawn);
        assertEquals(start, result);
    }
}
