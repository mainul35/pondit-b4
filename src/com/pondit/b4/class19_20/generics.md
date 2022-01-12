## Advantages

1. Type-safety
2. Type casting is not required
3. Compile-Time Checking

## Generics upper bound and lower bound

To understand, first define some classes with parent-child relationships.
```
class GrandPa {}
class Son extends GrandPa {}
class Daughter extends GrandPa {}
class GrandChild1 extends Son {}
class GrandChild2 extends Daughter {}
class GrandChild3 extends Son {}
```

### Upper bound

1. Upper bound works at definition level.

Example of definition level:
```
class GenericsUpperBoundTest <T extends Daughter>{}
```

Or,

```
    public <P extends Son> void addSon(P p){
        System.out.println(p);
    }
    
    ...........................................
    
    upperBoundTest.addSon(son);
    upperBoundTest.addSon(grandChild1);
    upperBoundTest.addSon(grandChild3);
    
```

Full example:

```
class GenericsUpperBoundTest <T extends Daughter>{

    List<T> list = new ArrayList<>();
    
    public static void main(String[] args) {
        GrandPa grandPa = new GrandPa();
        Daughter daughter = new Daughter();
        Son son = new Son();
        GrandChild1 grandChild1 = new GrandChild1();
        GrandChild2 grandChild2 = new GrandChild2();
        GrandChild3 grandChild3 = new GrandChild3();

        GenericsUpperBoundTest<Daughter> upperBoundTest = new GenericsUpperBoundTest<>();

        upperBoundTest.list.add(daughter);
        upperBoundTest.list.add(grandChild2);
        
        // followings are out of upper bound reach
        // upperBoundTest.list.add(grandPa);
        // upperBoundTest.list.add(son);
        // upperBoundTest.list.add(grandChild1);
        // upperBoundTest.list.add(grandChild3);
    }
}
```

2. At definition level, it never can hold wildcard, rather it requires a specific generic type. So the following code will be invalid.
```
class GenericsUpperBoundTest <? extends Daughter>{}

```

3. The following list seems to accept any subtype of Daughter, but while adding item, it will not also work.
```
List<? extends Daughter> list = new ArrayList<>();
        list.add(daughter);
        list.add(grandChild2); // sub type of daughter
        list.add(grandPa);
        list.add(son);
        list.add(grandChild1);
        list.add(grandChild3);
```

### Lower bound
1. Lower bound is never possible at definition level

example:
```
class GenericsLowerBoundTest <T super Son> {}

```
or
```
    public <P super Son> void addSon(P p){
        System.out.println(p);
    }
```

Both the above codes will prone to error.

2. Lower bound only works for any implementation, and also supports wildcard operator.

Example:

```
    List<? super Son> list = new ArrayList<>();
    list.add(grandChild1);
    list.add(grandChild3);
    list.add(son);
    // followings are out of lower bound reach
//        list.add(grandChild2);
//        list.add(grandPa);
//        list.add(daughter);
```