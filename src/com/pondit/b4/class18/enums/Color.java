package com.pondit.b4.class18.enums;

import java.util.Arrays;

public enum Color {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF");

    private String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}

class ColorEnumTest {
    public static void main(String[] args) {
        Color red = Color.RED;
        Arrays.stream(Color.values())
//                .filter(color -> color.equals(red))
                .forEach(color -> System.out.println(color + " = "+color.getCode()));
    }
}