package com.pondit.b4.class5.inheritance.scenario2;

import com.pondit.b4.class5.inheritance.Vehicle;

public class Car extends Vehicle {
    private int seatCount;
    private boolean isLuxurious;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public boolean isLuxurious() {
        return isLuxurious;
    }

    public void setLuxurious(boolean luxurious) {
        isLuxurious = luxurious;
    }

    public int getCurrentSpeed() {
        return (int) (Math.random() * (140 + 1) + 0);
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatCount=" + seatCount +
                ", isLuxurious=" + isLuxurious +
                ", axlesCount=" + axlesCount +
                ", hasSeats=" + hasSeats +
                ", runBy='" + runBy + '\'' +
                '}';
    }
}
