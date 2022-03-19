In Part 1 we discussed the use cases of Generics with Wildcard, Generic Type, 
Upper Bound and Lower Bound. In our today's tutorial I will try to explain the 
use cases of **Using Generic types as parameter of a class or an interface, Using Generic types with method or constructor definition and Arrays with Generic types.**

## Using Generic types as parameter of a class or an interface

Sometimes we feel the need of making some class that may work as a container to contain some instance, but which is difficult
to fix at compile time or creation of the class. In other words, our container class may hold an instance of a class
which will be determined while instantiating our container class. We have seen such example while we tried to create 
an instance of any collection type.

In such case, we define the class with a generic type.

```
class ResponseEntity<T> {
    private T t;
 }
```

We can also ``extends`` to set the upper limit. But we can never set the lower limit with ```super``` in the definition level.

```
class ResponseEntity<T extends Fruit> {
    private T t;
}
```

This above list will only accept any child of ``Fruit``. Therefore, it will not accept an instance of ``Object`` class.

## Using Generic types with method or constructor definition

Sometimes we may need to pass an instance of any class in a constructor or a method. But the class containing such a method
may not have a generic type parameter. In such case, we can only define the method with accepting types. An example is given below.

```
   public static  <IN> ResponseEntity ok(IN body) {
      ....................
      ....................
   }
```

If you carefully examine the above example, you will notice that the above method returns an instance of ``ResponseEntity``. But we also have a `<IN>` beforehand.
In the parameter we are accepting an instance of this ``IN`` type.

Just like **Generic type with class**, we can also write ``<IN extends Fruit>``, meaning that our method will accept any instance of child class of ``Fruit`` as an argument.
But we cannot use ``<IN super Fruit>``.

````
    public static <IN extends Fruit> ResponseEntity ok(IN body) {
        var respEntity = new ResponseEntity<>();
        respEntity.t = body;
        System.out.println("Created container of type: "+ body.getClass());
        return respEntity;
    }
````

### We can never use Wildcard as a Type

Let's say we want to try to use Wildcard while declaring a method or a constructor or a class. We will never be able to do it 
because the type of any variable or a field or an argument can never be declared with `?`.

I hope the below example will make the above statement clear.

````
class ResponseEntity<? extends Fruit> {
    private ? t;                                                     // Never possible
    
     public static <? extends Fruit> ResponseEntity ok(? body) {    // Never possible
        var respEntity = new ResponseEntity<>();
        respEntity.t = body;
        System.out.println("Created container of type: "+ body.getClass());
        return respEntity;
    }
}
````

> To summarize the above 2 topics, we can use Type parameter and extends at method / class / constructor definition level.
But can never use ``?`` or ``super``

The full code example of the 2 above topic is given below.

````
/**
 * Using Generic Type T for class
 * An example of Using Generic types as parameter of a class or an interface
 * */

class ResponseEntity<T> {
    private T t;

    /**
     * Introducing new Generic Type P for this constructor 1st parameter
     * Using already defined generic type T from class definition in 2nd parameter
     * An example of Using Generic types with constructor definition
     * */
    
    private <P> ResponseEntity (P p, T t) {
        System.out.println(p);
        this.t = t;
    }

    /**
     * Introducing <IN extends Fruit> new generic type to be passed through method parameter
     * Example of Using Generic types with method definition
     * */
    
    public static  <IN extends Fruit> ResponseEntity ok(IN body) {
        var respEntity = new ResponseEntity<>("Creating Response Entity with provided type...", body);
        respEntity.t = body;
        System.out.println("Created container of type: "+ body.getClass());
        return respEntity;
    }

    public T body() {
        return this.t;
    }
}

Code in main method
=============================================
  ResponseEntity fruitResponse = ResponseEntity.ok(new AsianApple());
  System.out.println(fruitResponse.body());
=============================================

Output
=============================================
Creating Response Entity with provided type...
Created container of type: class com.pondit.b4.class19_20.AsianApple
This is an AsianApple !!
=============================================

````
## Arrays with Generic types

Since we know how to define a class or a method with Generic type, it will be easy for us now to understand the definition of 
generic type Array.

Take a look at following example:

````
class TestGenericArray <T> {
    private T[] elements; //GOOD
    int count = 0;

    public TestGenericArray() {
//        elements = new T[10];         // ERROR, T is not a class known by the compiler
//        elements = new Object[10];    // ERROR, elements is not an array of Object
        elements = getArray(100);   // GOOD, but may lead to ClassCastException or ArrayStoreException in the future.
    }

    public <R> R[] getArray(int size) {
        R[] arr = (R[]) new String[size];   // Notice that we have cast our String array to the provided type and returning it
        return arr;
    }

    public void addElement(T t) {
        elements[count] = t;
        count++;
    }

    public void printElements() {
        for (T element: elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        TestGenericArray<Integer> testGeneric = new TestGenericArray<>();   // Notice here that we have passed Integer as type.
        testGeneric.addElement(10);         // While trying to execute this operation, we will get ArrayStoreException
        testGeneric.printElements();
    }
}
````

In this above example we not only tried to demonstrate Generic Array example, but also explained some precautions while trying to
work with Generic type Array. I hope, it will help.

Thank you for taking your time and patience to read this Article.