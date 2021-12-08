package com.pondit.b4.class12.returnTypeAsClassOrInterface;

public class Car {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public static Car getMyCar(String brand) {
        Car car = new Car();
        car.brand = brand;
        return car;
    }
}
