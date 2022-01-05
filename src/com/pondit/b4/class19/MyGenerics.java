package com.pondit.b4.class19;

public class MyGenerics <T>{

    private T t;

    public T getObject() {
        return t;
    }

    public void setObject(T t) {
        this.t = t;
    }

    public <R> void doSomething(R r) {
        System.out.println(r.getClass().getSimpleName());
    }
}
