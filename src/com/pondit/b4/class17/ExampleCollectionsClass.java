package com.pondit.b4.class17;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleCollectionsClass {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(5);
        intList.add(1);
        intList.add(2);
        intList.add(4);
        intList.add(3);
        Collections.sort(intList);
        System.out.println(intList);
    }
}
