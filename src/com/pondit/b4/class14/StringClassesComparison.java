package com.pondit.b4.class14;

public class StringClassesComparison {

    public static void main(String[] args) {
        // Benchmark of concatenating with "+"
        String s1 = "";
        long millis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s1 = "s"+s1;
        }
        System.out.println(System.currentTimeMillis() - millis);

        // Benchmark of concatenating with concat() method
        s1 = "";
        millis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            s1 = "s".concat(s1);
        }
        System.out.println(System.currentTimeMillis() - millis);

        // Benchmark of concatenating with StringBuffer#concat() method
        StringBuffer sb = new StringBuffer("");
        millis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append("test");
        }
        System.out.println(System.currentTimeMillis() - millis);

        // Benchmark of concatenating with StringBuilder#concat() method
        StringBuilder sbd = new StringBuilder("");
        millis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sbd.append("test");
        }
        System.out.println(System.currentTimeMillis() - millis);
    }
}
