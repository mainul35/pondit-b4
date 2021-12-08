package com.pondit.b4.class12.returnTypeAsClassOrInterface;

public class Main {
    public static void main(String[] args) {
        Car car1 = Car.getMyCar("Toyota");
        Car car2 = Car.getMyCar("BMW");
        System.out.println(car1.getBrand());
        System.out.println(car2.getBrand());
    }
}
