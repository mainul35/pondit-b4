package com.pondit.b4.class29.functionalProgrammingConcept;

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