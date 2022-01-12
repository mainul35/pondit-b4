package com.pondit.b4.class19_20;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        doSomething(12.5, 13);

        List<Integer> integers = new ArrayList<>();

        MyGenerics<Integer> myGenerics = new MyGenerics<>();
        myGenerics.setObject(134);
        List<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add("1");
    }

    static void doSomething(Object o1, Object o2) {
        Integer i = (int)o1 + (int)o2;
        System.out.println(i);
    }
}
