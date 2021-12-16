package com.pondit.b4.class15.errorsAndExceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String s) {
        super(s);
    }
}
