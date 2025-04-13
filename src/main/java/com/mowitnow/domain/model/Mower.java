package com.mowitnow.domain.model;

import com.mowitnow.domain.model.exception.InvalidMoveException;

public class Mower {

    private Position position;

    public Mower(int x, int y, Orientation orientation) {
        this.position = new Position(x, y, orientation);
    }

    public void mowing(String instructions, Lawn lawn) {
        for (char move : instructions.toCharArray()) {
            switch (move) {
                case 'L' -> position = position.turnLeft();
                case 'R' -> position = position.turnRight();
                case 'F' -> position = position.moveForward(lawn);
                default -> throw new InvalidMoveException(move);
            }
        }
    }

    public Position getPosition() {
        return position;
    }
}
