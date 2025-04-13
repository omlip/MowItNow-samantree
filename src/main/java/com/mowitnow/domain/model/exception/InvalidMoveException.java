package com.mowitnow.domain.model.exception;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(char move) {
        super("Invalid move: " + move);
    }
}
