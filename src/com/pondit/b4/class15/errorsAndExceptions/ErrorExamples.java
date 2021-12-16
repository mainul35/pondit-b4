package com.pondit.b4.class15.errorsAndExceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorExamples {
    public static void main(String[] args) {
//        callMe();
        List<String> list = new ArrayList<>();
        while (true) {
            list.add("");
        }
    }

    static void callMe() {
        System.out.println("I have been called");
        callMeToo();
    }

    private static void callMeToo() {
        System.out.println("Thanks for calling me");
        callMeToo1();
    }

    private static void callMeToo1() {
        System.out.println("Thanks for calling me 1");
    }
}
