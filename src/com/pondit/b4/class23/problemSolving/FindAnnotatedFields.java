package com.pondit.b4.class23.problemSolving;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FindAnnotatedFields {

    /**
     * 1. A class has 2 fields annotated with @Autowired annotation
     * 2. We will explore the fields, create instantiate the fields
     * 3. We will reuse and inject the already instantiated objects (beans)
     * */
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        BookService bookService = new BookService();

        Map<String, Object> map = new HashMap<>();

        Field[] fields = bookService.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getDeclaredAnnotation(Autowired.class) != null) {
                field.setAccessible(true);
                if (field.get(bookService) == null) {
                    // Get actual type with field.getType()
                    var type = field.getType();
                    var typeName = type.getName();
                    if (map.containsKey(typeName)) {
                        field.set(bookService, map.get(typeName));
                    } else {
                        var constructor = type.getDeclaredConstructors()[0];
                        constructor.setAccessible(true);
                        var instance = constructor.newInstance();
                        field.set(bookService, instance);
                        map.put(typeName, instance);
                    }
                }
            }
        }
        System.out.println(bookService);
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Autowired {

}

class BookService {

    @Autowired
    private BookRepository bookRepository1;

    @Autowired
    private BookRepository bookRepository2;

    @Override
    public String toString() {
        return "BookService{" +
                "bookRepository1=" + bookRepository1 +
                ", bookRepository2=" + bookRepository2 +
                '}';
    }
}


class BookRepository {

}