package com.pondit.b4.class16.collectionFrameworks.Lists;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList();

        Student tanveer = new Student();
        tanveer.setName("Tanveer");
        tanveer.setRoll(12);

        Student alAmin = new Student();
        alAmin.setName("AlAmin");
        alAmin.setRoll(14);

        Student s3 = new Student();
        s3.setName("Rumon");
        s3.setRoll(33);

        list.add(tanveer);
        list.add(alAmin);
        list.add(s3);

        printList(list);

        // ======================ArrayList sequencing check =======================
        System.out.println("======================ArrayList sequencing check =======================");
        List<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(13);
        integers.add(4);
        integers.add(5);
        integers.add(13);

        printList(integers);

        // Remove with index
        integers.remove(2);
        printList(integers);

        Collections.sort(integers);
        printList(integers);

        // Remove as object
        integers.remove(Integer.valueOf(13));
        printList(integers);

        System.out.println(integers.contains(5));
    }

    private static void printList(List list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}


class Student {
    private String name;
    private int roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                '}';
    }
}