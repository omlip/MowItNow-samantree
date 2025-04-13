package com.mowitnow.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MowerTest {

    @Test
    void shouldFollowInstructionsCorrectly() {
        Lawn lawn = new Lawn(5, 5);

        Mower mower = new Mower(1, 2, Orientation.N);

        mower.mowing("LFLFLFLFF", lawn);

        assertEquals(new Position(1, 3, Orientation.N), mower.getPosition());
    }

    @Test
    void shouldHandleSecondTestMower() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(3, 3, Orientation.E);

        mower.mowing("FFRFFRFRRF", lawn);

        assertEquals(new Position(5, 1, Orientation.E), mower.getPosition());
    }

}
