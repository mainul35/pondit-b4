package com.pondit.b4.class15.errorsAndExceptions;

import java.io.IOException;

public class ExceptionExamples {

    public static void main(String[] args) {
        System.out.println(divide(2, 0));

        try {
            Class.forName("com.pondit.b4.class15.errorsAndExceptions.ExceptionExamples");
        } catch (ClassNotFoundException | RuntimeException e) {
            throw new NotFoundException("Your required class was not found");
        }
//        catch (RuntimeException e) {
//            e.printStackTrace();
//        }
    }

    static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException(" b cannot be 0");
        } else {
            return a / b;
        }
    }
}
