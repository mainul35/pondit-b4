package com.pondit.b4.class30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamExamples {

    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        init(menu);

        // Before
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish dish: menu) {
            if(dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish dish: lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        System.out.println(lowCaloricDishesName);
        // After

        lowCaloricDishesName =
                menu.stream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories).reversed().thenComparing(Dish::getName))
                        .map(Dish::getName)
                        .collect(toList());

        System.err.println(lowCaloricDishesName);
    }

    private static void init(List<Dish> menu) {
        Dish dish1 = new Dish();
        dish1.setCalories(395);
        dish1.setName("Burger");
        menu.add(dish1);

        Dish dish2 = new Dish();
        dish2.setCalories(700);
        dish2.setName("Biriani");
        menu.add(dish2);

        Dish dish3 = new Dish();
        dish3.setCalories(890);
        dish3.setName("Kacchi");
        menu.add(dish3);

        Dish dish4 = new Dish();
        dish4.setCalories(540);
        dish4.setName("Pizza");
        menu.add(dish4);

        Dish dish5 = new Dish();
        dish5.setCalories(330);
        dish5.setName("Dal");
        menu.add(dish5);

        Dish dish6 = new Dish();
        dish6.setCalories(210);
        dish6.setName("vegetables");
        menu.add(dish6);

        Dish dish7 = new Dish();
        dish7.setCalories(330);
        dish7.setName("seafood");
        menu.add(dish7);
    }
}

class Dish {
    private String name;
    private int calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}