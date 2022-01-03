package com.pondit.b4.class16.collectionFrameworks.set;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        Set<String> set = new LinkedHashSet<>();
//        Set<String> set = new TreeSet<>();

        set.add("Al Amin");
        set.add("tanveer");
        set.add("Tanveer");
        set.add("Dipu");
        set.add("Nayeem");

        printList(set);
    }

    private static void printList(Set objects) {

        for (Object item : objects) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
