package com.pondit.b4.class6;

public class ThisAndSuperKeyword {

    int a = 5;
    ThisAndSuperKeyword () {
        System.out.println(this.a);
    }

    public static void main(String[] args) {
        ThisChildClass childClass = new ThisChildClass(15);
    }
}

class SuperParentClass {
    protected int numberFromSuper;

    SuperParentClass(int value) {
        this.numberFromSuper = value;
        System.out.println(this.numberFromSuper);
    }
}

class ThisChildClass extends SuperParentClass{
    public ThisChildClass (int value) {
        super(value);
        System.out.println(super.numberFromSuper);
        this.numberFromSuper = 10 + value;
        System.out.println(this.numberFromSuper);
    }
}