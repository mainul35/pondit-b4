package com.pondit.b4.class19_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenericTest {


    public static void main(String[] args) {

        List<String> stringList1 = new ArrayList<>();
        stringList1.add("Muhammad");
        stringList1.add("Al Fatih");

        Set<? super Number> numberSet = new HashSet<>();
        numberSet.add(2);
        numberSet.add(3);


        List<? super Fruit> basket = new ArrayList<>();
        List<? super Apple> basket1 = List.of(new Apple(), new AsianApple(), new Fruit(), new Object(), 123, 12.45);

        basket1.add(new Apple());    //Successful
        basket1.add(new AsianApple()); //Successful
//        basket1.add(new Fruit());    //Compile time error
//        basket1.add(new Object());    //Compile time error



        List<AsianApple> basket2 = new ArrayList<>();
        basket2.add(new AsianApple());
        printApples(basket);

        List<Fruit> basket3 = new ArrayList<>();
        basket3.add(new AsianApple());
        basket3.add(new Apple());
        basket3.add(new Fruit());
        printApples(basket3);


    }

    public static void printApples(List<? super Apple> apples)
    {
        System.out.println(apples);
    }
}

class TestGenericArray <T> {
    private T[] elements; //GOOD
    int count = 0;

    public TestGenericArray() {
//        elements = new T[10];         // ERROR, T is not a class known by the compiler
//        elements = new Object[10];    // ERROR, elements is not an array of Object
        elements = getArray(100);   // GOOD, but may lead to ClassCastException or ArrayStoreException in the future.
    }

    public <R> R[] getArray(int size) {
        R[] arr = (R[]) new String[size];   // Notice that we have cast our String array to the provided type and returning it
        return arr;
    }

    public void addElement(T t) {
        elements[count] = t;
        count++;
    }

    public void printElements() {
        for (T element: elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        TestGenericArray<Integer> testGeneric = new TestGenericArray<>();   // Notice here that we have passed Integer as type.
        testGeneric.addElement(10);         // While trying to execute this operation, we will get ArrayStoreException
        testGeneric.printElements();
    }
}


class Fruit {
    @Override
    public String toString() {
        return "Any fruit!!";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "This is an Apple !!";
    }
}

class AsianApple extends Apple {
    @Override
    public String toString() {
        return "This is an AsianApple !!";
    }
}


/**
 * Using Generic Type T for class
 * An example of Using Generic types as parameter of a class or an interface
 * */

class ResponseEntity<T> {
    private T t;

    /**
     * Introducing new Generic Type P for this constructor 1st parameter
     * Using already defined generic type T from class definition in 2nd parameter
     * An example of Using Generic types with constructor definition
     * */

    private <P> ResponseEntity (P p, T t) {
        System.out.println(p);
        this.t = t;
    }

    /**
     * Introducing <IN extends Fruit> new generic type to be passed through method parameter
     * Example of Using Generic types with method definition
     * */

    public static  <IN extends Fruit> ResponseEntity ok(IN body) {
        var respEntity = new ResponseEntity<>("Creating Response Entity with provided type...", body);
        respEntity.t = body;
        System.out.println("Created container of type: "+ body.getClass());
        return respEntity;
    }

    public T body() {
        return this.t;
    }

    public <T extends Fruit> List<? extends Fruit> add(T... instances) {
        List<T> fruits = new ArrayList<>();
        for (T t: instances) {
            fruits.add(t);
        }
        return fruits;
    }
}