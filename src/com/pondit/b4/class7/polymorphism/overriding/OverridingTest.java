package com.pondit.b4.class7.polymorphism.overriding;

public class OverridingTest {
    /**
     * ================== Overriding keypoints ===================
     * 1. Must have a parent-child relationship between classes
     * 2. Parent class method name and child class method name must be same
     * 3. method parameter counts and their types must be same
     * 4. return types of both methods must be same
     * 5. access modifier of child method must be same or higher than parent class (private is never possible)
     * */

    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        ParentClass childClass = new ChildClass();
        parentClass.run();
        childClass.run();
    }
}

class ParentClass {

    protected void run() {
        System.out.println("Parent class run method called");
    }
}

class ChildClass extends ParentClass {

    public void run() {
        super.run();
        System.out.println("Child class run method called");
    }

    public void walk() {
        System.out.println("Child class run method called");
    }
}