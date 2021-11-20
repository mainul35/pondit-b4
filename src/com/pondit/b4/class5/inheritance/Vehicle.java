package com.pondit.b4.class5.inheritance;

public class Vehicle {
    boolean hasAxles = true;
    protected int axlesCount;
    protected boolean hasSeats;
    protected String runBy;

    @Override
    public String toString() {
        return "Vehicle{" +
                "hasAxles=" + hasAxles +
                ", axlesCount=" + axlesCount +
                ", hasSeats=" + hasSeats +
                ", runBy='" + runBy + '\'' +
                '}';
    }
}
