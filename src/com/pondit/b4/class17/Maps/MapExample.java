package com.pondit.b4.class17.Maps;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
//        Map<Integer, String> map = new LinkedHashMap<>();
//        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "Abir");
        map.put(3, "Naim");
        map.put(2, "Adnan");
        map.put(7, "Siam");
        map.put(4, "Rafi");

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
