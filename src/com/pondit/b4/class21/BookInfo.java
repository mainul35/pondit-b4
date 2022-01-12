package com.pondit.b4.class21;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
        ElementType.TYPE,
        ElementType.FIELD,
})
@Retention(RetentionPolicy.RUNTIME)
public @interface BookInfo {
    String bookName();
    String isbn();
    String author();
    String publisher();
}