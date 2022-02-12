package com.pondit.b4.class30_31;

import java.util.*;

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

        var dishes =
                menu.stream()
                        .filter(d -> d.getCalories() < 400)
                        // first sort by calories.
                        // Then reverse to descending order.
                        // If more than one dish have same calories, then sort by name.
                        .sorted(comparing(Dish::getCalories).thenComparing(Dish::getName))
                        .map(StreamExamples::getOnlyNameAndCalories)
                        .collect(toList());

        System.err.println(dishes);
    }

    private static HashMap<String, Object> getOnlyNameAndCalories(Dish dish) {
        var map = new HashMap<String, Object>();
        map.put("name", dish.getName());
        map.put("calories", dish.getCalories());
        return map;
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
    private String foodType;

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

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

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}