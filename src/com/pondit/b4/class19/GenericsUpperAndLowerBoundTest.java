package com.pondit.b4.class19;

import java.util.ArrayList;
import java.util.List;

class GenericsUpperBoundTest <T extends Daughter>{

    List<T> list = new ArrayList<>();

    public static void main(String[] args) {
        GrandPa grandPa = new GrandPa();
        Daughter daughter = new Daughter();
        Son son = new Son();
        GrandChild1 grandChild1 = new GrandChild1();
        GrandChild2 grandChild2 = new GrandChild2();
        GrandChild3 grandChild3 = new GrandChild3();

        GenericsUpperBoundTest<Daughter> upperBoundTest = new GenericsUpperBoundTest<>();

        upperBoundTest.list.add(daughter);
        upperBoundTest.list.add(grandChild2);
        // followings are out of upper bound reach
//        upperBoundTest.list.add(grandPa);
//        upperBoundTest.list.add(son);
//        upperBoundTest.list.add(grandChild1);
//        upperBoundTest.list.add(grandChild3);

//        List<? extends Daughter> list = new ArrayList<>();
//        list.add(daughter);
//        list.add(grandChild2);
//        list.add(grandPa);
//        list.add(son);
//        list.add(grandChild1);
//        list.add(grandChild3);

    }

    static public <P extends Son> void addSon(P p){
        System.out.println(p);
    }
}

class GenericsLowerBoundTest <T> {

    public static void main(String[] args) {
        GrandPa grandPa = new GrandPa();
        Daughter daughter = new Daughter();
        Son son = new Son();
        GrandChild1 grandChild1 = new GrandChild1();
        GrandChild2 grandChild2 = new GrandChild2();
        GrandChild3 grandChild3 = new GrandChild3();
        List<? super Son> list = new ArrayList<>();
        list.add(grandChild1);
        list.add(grandChild3);
        list.add(son);
//        list.add(grandChild2);
//        list.add(grandPa);
//        list.add(daughter);
    }

}

class GrandPa {}
class Son extends GrandPa {}
class Daughter extends GrandPa {}
class GrandChild1 extends Son {}
class GrandChild2 extends Daughter {}
class GrandChild3 extends Son {}