package com.pondit.b4.class19_20;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;

public interface ArithmaticOperations<IN1, IN2, RETURN> {
    default void print(IN2 second) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        var clazz = second.getClass();
        var name = clazz.getMethod("getName").invoke(second);
        var age = clazz.getMethod("getAge").invoke(second);
        System.out.println(name);
        System.out.println(age);
    }

    RETURN add(IN1 f, IN2 s);
}

class TestArithmatic {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
//        ArithmaticOperations<Integer, Person> operations = new ArithmaticOperations<>();
//
//        Person person = new Person();
//        person.setAge(10);
//        person.setName("asdf");
//
//        operations.print(person);

        BiFunction<Integer, Integer, Integer> biFunction = (Integer t, Integer u) -> t + u;

        biFunction.apply(19, 20);

        ArithmaticOperations<Integer, Double, Double> operations = new ArithmaticOperations<Integer, Double, Double>() {
            @Override
            public Double add(Integer f, Double s) {
                return f + s;
            }
        };

        ArithmaticOperations<Integer, Double, Double> operations1 = (f, s) -> f + s;
        System.out.println(operations1.add(10, 20.4));
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