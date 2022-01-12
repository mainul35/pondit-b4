package com.pondit.b4.class19_20;

import java.lang.reflect.InvocationTargetException;

public class ArithmaticOperations<FIRST, SECOND> {
    private FIRST first;
    private SECOND second;

    public ArithmaticOperations() {
        this.first = first;
        this.second = second;
    }

    public void print(SECOND second) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        var clazz = second.getClass();
        var name = clazz.getMethod("getName").invoke(second);
        var age = clazz.getMethod("getAge").invoke(second);
        System.out.println(name);
        System.out.println(age);
    }
}

class TestArithmatic {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        ArithmaticOperations<Integer, Person> operations = new ArithmaticOperations<>();

        Person person = new Person();
        person.setAge(10);
        person.setName("asdf");

        operations.print(person);
    }
}

class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}