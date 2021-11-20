package com.pondit.b4.class7.polymorphism.overloading;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class OverloadingTest {

    /**
     * ================== Overloading keypoints ===================
     * 1. Class must be same
     * 2. return type doesn't matter
     * 3. Method names must be same
     * 4. Either parameter type or parameter count must be different
     * */
    public void overloadedMethod() {
        System.out.println("I have no parameter");

        // Practical example of overloading from Java LocalDateTime API
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now(ZoneId.of("UTC+4")));
    }

    protected void overloadedMethod(String a) {
        System.out.println("I have a String parameter");
    }

    private void overloadedMethod(Double a) {
        System.out.println("I have a Double parameter");
    }


    public static void main(String[] args) {
        OverloadingTest test = new OverloadingTest();
        test.overloadedMethod();
        test.overloadedMethod("asfdf");
        test.overloadedMethod(0.0);

    }
}

