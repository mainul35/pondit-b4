package com.pondit.b4.class12.singleton;

import java.lang.reflect.InvocationTargetException;

public class SingletonLazy {
    private static SingletonLazy obj; //LAZY, instance will be created at getInstance() method call
    private SingletonLazy(){
        if (obj != null) {
            throw new RuntimeException("Instance is already initialized");
        }
    }

    public static SingletonLazy getInstance(){
        if (obj == null) {
            obj = new SingletonLazy();
        }
        return obj;
    }

    public void doSomething(){
        //write your code
        System.out.println("Something");
    }

}

class SingletonLazyMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonLazy lazy = SingletonLazy.getInstance();
        lazy.doSomething();
        System.out.println(lazy.hashCode());

        Class<SingletonLazy> claz = (Class<SingletonLazy>) Class.forName("com.pondit.b4.class12.singleton.SingletonLazy");
        var constructor = claz.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        var newInstance = constructor.newInstance();
        System.out.println(lazy instanceof SingletonLazy);
        System.out.println(newInstance instanceof SingletonLazy);
        System.out.println(lazy.hashCode());
        System.out.println(newInstance.hashCode());
    }
}