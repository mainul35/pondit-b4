package com.pondit.b4.class15.errorsAndExceptions;

public class ExceptionExamples {

    public static void main(String[] args) {
        System.out.println(divide(2, 0));

        try {
            Class.forName("com.pondit.b4.class15.errorsAndExceptions.ExceptionExamples");
        } catch (ClassNotFoundException e) {
            throw new NotFoundException("Your required class was not found");
        }
    }

    static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException(" b cannot be 0");
        } else {
            return a / b;
        }
    }
}
