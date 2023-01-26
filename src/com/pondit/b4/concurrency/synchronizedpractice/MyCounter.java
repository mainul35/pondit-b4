package com.pondit.b4.concurrency.synchronizedpractice;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

public class MyCounter {
    private volatile int count = 0;

    Logger logger = Logger.getLogger(getClass().getName());

    public void add(int value){
        this.count += value;
    }
    public void subtract(int value){
        this.count -= value;
    }

    public int getCount() {
        return this.count;
    }

    public static void main(String[] args) {
        var myCounter = new MyCounter();
        Runnable r1 = () -> {
            int i = 0;
            while (i++ < 10) {
                synchronized (myCounter) {
                    myCounter.add(10);
                    System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
                }

            }
        };
        Runnable r2 = () -> {
            int i = 0;
            while (i++ < 10) {
                synchronized (myCounter) {
                    myCounter.subtract(1);
                    System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
                }
            }
        };

//        var t1 = new Thread(r1);
//        t1.start();
//        var t2 = new Thread(r2);
//        t2.start();

        Runnable r3 = () -> {
            System.out.println("=================== Without Synchronization or Atomic ===================");
            int i = 0;
            while (i++ < 10) {
                myCounter.add(1);
                System.out.println(Thread.currentThread().getName() + ", Not Synchronized, counter = "+ i+": " + myCounter.getCount());
//                myCounter.subtract(1);
//                System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
            }
        };

        new Thread(r3).start();

        Runnable r4 = () -> {
            System.out.println("=================== With Synchronization ===================");
            int i = 0;
            while (i++ < 10) {
                synchronized (myCounter) {
                    myCounter.add(1);
                    System.out.println(Thread.currentThread().getName() + ", synchronized, counter = "+ i+": " + myCounter.getCount());
//                    myCounter.subtract(1);
//                    System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
                }
            }
        };
        new Thread(r4).start();

        Runnable r5 = () -> {
            System.out.println("=================== With Atomic ===================");
            int i = 0;
            AtomicReference<MyCounter> myCounterAtomicReference = new AtomicReference<>(myCounter);
            while (i++ < 10) {
                myCounterAtomicReference.get().add(1);
                System.out.println(Thread.currentThread().getName() + ", atomic, counter = "+ i+": " +  myCounterAtomicReference.get().getCount());
//                myCounterAtomicReference.get().subtract(1);
//                System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounterAtomicReference.get().getCount());
            }
        };
        new Thread(r5).start();
    }
}
