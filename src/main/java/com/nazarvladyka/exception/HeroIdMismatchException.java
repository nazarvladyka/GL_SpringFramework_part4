package com.nazarvladyka.exception;

public class HeroIdMismatchException extends RuntimeException {
    public HeroIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}