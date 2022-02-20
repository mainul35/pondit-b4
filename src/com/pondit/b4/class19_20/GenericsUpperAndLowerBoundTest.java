package com.pondit.b4.class19_20;

import java.util.ArrayList;
import java.util.List;

class GenericsUpperBoundTest <T extends Daughter>{

    List<T> list = new ArrayList<>();

    public static void main(String[] args) {
        // This is an exceptional example of using wildcard in upper bound definition. This code will work.
        // We can call it definition level use case, because we defined the List and populated with value in one go
        List<? extends GrandPa> childrenOfGrandPa = List.of(new GrandPa(), new Daughter(), new GrandChild2());

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