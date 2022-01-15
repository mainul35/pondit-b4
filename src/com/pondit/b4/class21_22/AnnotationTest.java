package com.pondit.b4.class21_22;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AnnotationTest {

    @BookInfo(bookName = "Spring 5 in Action", author = "Craig Walls", isbn = "9781617294945", publisher = "Manning")
    private String springInAction;

    private String s1;
    private int i2;

    private AnnotationTest(String s1, Integer i1) {
        this.s1 = s1;
        this.i2 = i1;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Field field = AnnotationTest.class.getDeclaredField("springInAction");

        AnnotationTest test = AnnotationTest.class
                .getDeclaredConstructor(String.class, Integer.class).newInstance("abc", 123);
        System.out.println(test.s1);
        System.out.println(test.i2);

        BookInfo bookInfo = (BookInfo) field.getAnnotations()[0];
        System.out.println(bookInfo.author());
        System.out.println(bookInfo.bookName());
        System.out.println(bookInfo.isbn());
        System.out.println(bookInfo.publisher());
    }
}

