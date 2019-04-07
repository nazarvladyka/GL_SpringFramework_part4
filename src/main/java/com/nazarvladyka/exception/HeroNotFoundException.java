package com.nazarvladyka.exception;

public class HeroNotFoundException extends RuntimeException {
    public HeroNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}