package com.pondit.b4;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CodingTest {
    public CodingTest() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        Integer x = 3;
        Integer y = null;

        try {
            System.out.println(Integer.compareUnsigned(x, 3) == 0 || Integer.compareUnsigned(y,0) == 0);

        } catch (Exception e) {
            System.out.println(e.getClass().toString());
        }

        try {
            System.out.println(y.compareTo(null) == 0 || true);
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }
    }

//    BufferedReader br = new BufferedReader("input.dat");

}

class A {

}

class B extends A{
    public B() {
        System.out.println();
    }

    public B(int a) {
        super();
        System.out.println();
    }

//    void a() {
//        super();
//        this();
//    }
}
