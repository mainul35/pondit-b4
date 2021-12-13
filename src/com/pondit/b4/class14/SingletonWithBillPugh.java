package com.pondit.b4.class14;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingletonObject implements Serializable {
    private static class Holder {
        static final SingletonObject INSTANCE = new SingletonObject();
    }

    private SingletonObject () {
        if (Holder.INSTANCE != null) {
            throw new RuntimeException("An instance is already created");
        }
    }

    public static SingletonObject getInstance() {
        return Holder.INSTANCE;
    }

    private Object readResolve () {
        System.out.println("Read resolved");
        return getInstance();
    }

    public void useSingleton() {
        SingletonObject obj = SingletonObject.getInstance();
//        System.out.println();
    }
}


public class SingletonWithBillPugh {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        SingletonObject object1 = SingletonObject.getInstance();
        SingletonObject object2 = SingletonObject.getInstance();
        print("object1", object1);
        print("object2", object2);

        // with reflection
        Class clazz = Class.forName("com.pondit.b4.class14.SingletonObject");
        Constructor<SingletonObject> constructor = clazz.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
//        SingletonObject object3 = constructor.newInstance(new Object[0]);
//        print("object3", object3);

        // With serialization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.home") + "/obj4.ser"));
        objectOutputStream.writeObject(object2);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(System.getProperty("user.home") + "/obj4.ser"));
        SingletonObject object4 = (SingletonObject) objectInputStream.readObject();
        print("object4", object4);

        // Multithreaded
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            SingletonObject.getInstance();
        });
        executorService.submit(() -> {
            SingletonObject.getInstance();
        });

        executorService.shutdown();
    }

    static void print (String name, SingletonObject object) {
        System.out.println(String.format("Object: %s, Hashcode: %d", name, object.hashCode()));
    }
}
