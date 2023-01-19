package com.pondit.b4.concurrency.synchronizedpractice;

public class MyCounter {
    private int count = 0;

    public synchronized void add(int value){
        this.count += value;
    }
    public synchronized void subtract(int value){
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
                myCounter.add(1);
                System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
            }
        };
        Runnable r2 = () -> {
            int i = 0;
            while (i++ < 10) {
                myCounter.subtract(1);
                System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
            }
        };

        Runnable r3 = () -> {
            int i = 0;
            while (i++ < 10) {
//                synchronized (myCounter) {
                    myCounter.add(1);
                    System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
                    myCounter.subtract(1);
                    System.out.println(Thread.currentThread().getName() + ", counter = "+ i+": " + myCounter.getCount());
//                }
            }
        };

//        var t1 = new Thread(r1);
//        t1.start();
//        var t2 = new Thread(r2);
//        t2.start();

        var t3 = new Thread(r3);
        t3.start();
        var t4 = new Thread(r3);
        t4.start();
    }
}
