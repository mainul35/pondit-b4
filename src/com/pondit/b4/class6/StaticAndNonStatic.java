package com.pondit.b4.class6;

public class StaticAndNonStatic {

    public static void main(String[] args) {
        StaticNonStaticTest test1 = new StaticNonStaticTest();
        test1.a = 5;
        StaticNonStaticTest.c = 40;
        System.out.println("=============== TEST 1 =====================");
        System.out.println(test1.a);
        System.out.println(test1.b);
        System.out.println(StaticNonStaticTest.c);

        System.out.println();
        System.out.println("=============== TEST 2 =====================");
        StaticNonStaticTest test2 = new StaticNonStaticTest();
        System.out.println(test2.a);
        System.out.println(test2.b);
        System.out.println(StaticNonStaticTest.c);
    }
}

class StaticNonStaticTest {
    int a = 10;
    int b = 20;
    static int c = 30;
}