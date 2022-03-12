package com.pondit.b4.class19_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenericsUpperBoundTest <T extends Daughter>{

    List<T> list = new ArrayList<>();

    public static void main(String[] args) {
        // This is an exceptional example of using wildcard in upper bound definition. This code will work.
        // We can call it definition level use case, because we defined the List and populated with value in one go
        List<? extends GrandPa> childrenOfGrandPa = List.of(new GrandPa(), new Daughter(), new GrandChild2());

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


        List<GrandPa> childrenOfGrandPa2 = new ArrayList<>();
        childrenOfGrandPa2.add(new Daughter());
        childrenOfGrandPa2.add(new GrandChild2());

        GenericsUpperBoundTest<Daughter> upperBoundTest = new GenericsUpperBoundTest<>();
        upperBoundTest.list.add(new Daughter());
        upperBoundTest.list.add(new GrandChild2());

        // however, followings are out of upper bound reach
//         upperBoundTest.list.add(new GrandPa());
//         upperBoundTest.list.add(new Son());
//         upperBoundTest.list.add(new GrandChild1());
//         upperBoundTest.list.add(new GrandChild3());

    }

    public static void printApples(List<? super Apple> apples)
    {
        System.out.println(apples);
    }

    public void addSon(List<? extends Son> p){
        System.out.println(p);
    }
}

class GenericsLowerBoundTest <T> {

    public static void main(String[] args) {
        List<? super Son> list = new ArrayList<>();
        list.add(new GrandChild1());
        list.add(new GrandChild3());
        list.add(new Son());
        // followings are out of lower bound reach
//        list.add(new GrandChild2());
//        list.add(new GrandPa());
//        list.add(new Daughter());
    }

}

class GrandPa {}
class Son extends GrandPa {}
class Daughter extends GrandPa {}
class GrandChild1 extends Son {}
class GrandChild2 extends Daughter {}
class GrandChild3 extends Son {}


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