package com.pondit.b4.class23.problemSolving;

import com.pondit.b4.class21_22.BookInfo;
import jdk.jfr.Experimental;

import java.lang.annotation.*;
import java.util.Arrays;


/**
 * We have declared 3 annotations on a class named <b>AnnotatedClass</b>
 * Our purpose is to read the annotations over this class and print them
 * */
public class FindingAnnotationsOnClass {

    public static void main(String[] args) {
        Annotation[] annotations = AnnotatedClass.class.getDeclaredAnnotations();
        Arrays.stream(annotations).forEach(System.out::println);
    }
}

@Experimental
@Deprecated
@Component
class AnnotatedClass {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {

}