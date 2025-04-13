package com.mowitnow.domain.model;

public class Lawn {

    private final int maxX;
    private final int maxY;

    public Lawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isInside(Position position) {
        return position.x() >= 0 && position.y() >= 0 &&
                position.x() <= maxX && position.y() <= maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
