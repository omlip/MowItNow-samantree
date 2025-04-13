package com.mowitnow.domain.model;

public record Position(int x, int y, Orientation orientation) {

    public Position moveForward(Lawn lawn) {
        int newX = this.x;
        int newY = this.y;

        switch (orientation) {
            case N -> newY++;
            case S -> newY--;
            case E -> newX++;
            case W -> newX--;
        }

        Position next = new Position(newX, newY, orientation);
        return lawn.isInside(next) ? next : this;
    }

    public Position turnLeft() {
        return new Position(x, y, orientation.turnLeft());
    }

    public Position turnRight() {
        return new Position(x, y, orientation.turnRight());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position(int x1, int y1, Orientation orientation1))) return false;
        return x == x1 && y == y1 && orientation == orientation1;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                '}';
    }
}
