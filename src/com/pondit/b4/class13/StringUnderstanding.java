package com.pondit.b4.class13;

public class StringUnderstanding {

    public static void main(String[] args) {
        String s1 = "Mainul";
        String s2 = "Mainul";
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.concat("hasan"));
        System.out.println(s1.concat("hasan").hashCode());
        System.out.println(s1);
        System.out.println(s1.hashCode());

        s1 = s1.concat("hasan");

        System.out.println("s1 hash code"+s1.hashCode());
        System.out.println(s1);

    }
}
