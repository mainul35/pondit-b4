package com.pondit.b4.class18.streamAPI;

import java.util.List;

public class StreamAndLambdaExample {
    public static void main(String[] args) {

        var reduce = List.of(1, 2, 3, 4, 5)
                .stream()
                .map(StreamAndLambdaExample::mapToDouble)
                .map(StreamAndLambdaExample::sumWithTwo)
                .map(StreamAndLambdaExample::print)
// ================= Terminal operators =============================
//                .allMatch(aDouble -> aDouble.equals(3.0));
//                .anyMatch(aDouble -> aDouble.equals(3.0));
//                .noneMatch(aDouble -> aDouble.equals(3.0));
//                .collect(Collectors.toList());
//                .count();
//                .forEach(MapExample::doSomeStuff);
//                .min((o1, o2) -> (int)(o1-o2));
//                .max((o1, o2) -> (int)(o1-o2));
//                .reduce((aDouble, aDouble2) -> (aDouble + aDouble2));
        .reduce(0.0, (subtotal, element) -> (subtotal + element));

        System.out.println(reduce);

//        System.out.println(distinct);
    }

    private static double mapToDouble(int num) {
        return (double) num;
    }

    private static double sumWithTwo(double num) {
        return num + 2;
    }

    private static double print(double num) {
        System.out.println(num);
        return num;
    }

    private static void doSomeStuff(double aDouble) {
        // call some 3rd party api...
    }
}
