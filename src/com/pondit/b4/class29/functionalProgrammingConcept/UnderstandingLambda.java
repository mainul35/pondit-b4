package com.pondit.b4.class29.functionalProgrammingConcept;

import java.util.function.Supplier;

/**
 *
 * f(x) = 2x+3
 *
 * f(3+2) = 13
 *
 * f(x, y) = 2x + 3y
 * */

public class UnderstandingLambda {
    public static void main(String[] args) {
        calculateFOfXAndY(new CalculateXAndYFunction() {
            @Override
            public int f(int x, int y) {
                return 2 * x + 3 * y;
            }
        });

        calculateFOfXAndY((x, y) -> {

            return 2 * x + 3 * y;
        });
    }

    public static void calculateFOfXAndY(CalculateXAndYFunction xAndYFunction) {
        System.out.println(xAndYFunction.f(1, 3));
    }
}


@FunctionalInterface
interface CalculateXAndYFunction {
    int f(int x, int y);
}


@FunctionalInterface
interface MyFunctionalInterface {
    void myFunction(String s);
}

class RunMyFunction {
    public static void main(String[] args) {

        // With anonymous inner class
        var myFunc = new MyFunctionalInterface() {
            @Override
            public void myFunction(String s) {
                System.out.println(s);
            }
        };

        // With Lambda
        MyFunctionalInterface myFunc1 = (String s) -> System.out.println(s);


        // Lambda as first class citizen
        runMyFunction((s) -> System.out.println(s));

        // Method Reference
        runMyFunction(System.out::println);

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };

    }

    public static void runMyFunction (MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.myFunction("Printing my function");
    }
}