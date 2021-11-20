package com.pondit.b4.class5.inheritance.scenario2;

import com.pondit.b4.class5.inheritance.Vehicle;

public class Cart extends Vehicle {
    protected boolean carryWeight;

    public int getAxlesCount() {
        return axlesCount;
    }

    public int getCurrentWeight() {
       return (int) (Math.random() * (60 + 1) + 0);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "axlesCount=" + axlesCount +
                ", hasSeats=" + hasSeats +
                ", runBy='" + runBy + '\'' +
                ", carryWeight=" + carryWeight +
                '}';
    }
}
