package com.pondit.b4.class12.singleton;

public class SingletonEager {
    private static SingletonEager obj=new SingletonEager();//EAGER, instance will be created at load time
    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return obj;
    }

    public void doSomething(){
        //write your code
        System.out.println("Something");
    }
}

class Main {
    public static void main(String[] args) {
        // start application
        // Check login
        //.....................
        SingletonEager singletonEager = SingletonEager.getInstance();
        singletonEager.doSomething();
    }
}