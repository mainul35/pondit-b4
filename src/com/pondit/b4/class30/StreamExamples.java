//package com.pondit.b4.class30;
//
//import static java.util.Comparator.comparing;
//import static java.util.stream.Collectors.toList;
//
//public class StreamExamples {
//
//    public static void main(String[] args) {
//
//        // Before
//        List<Dish> lowCaloricDishes = new ArrayList<>();
//        for(Dish dish: menu) {
//            if(dish.getCalories() < 400) {
//                lowCaloricDishes.add(dish);
//            }
//        }
//        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
//            public int compare(Dish dish1, Dish dish2) {
//                return Integer.compare(dish1.getCalories(), dish2.getCalories());
//            }
//        });
//        List<String> lowCaloricDishesName = new ArrayList<>();
//        for(Dish dish: lowCaloricDishes) {
//            lowCaloricDishesName.add(dish.getName());
//        }
//
//        // After
//
//        List<String> lowCaloricDishesName =
//                menu.stream()
//                        .filter(d -> d.getCalories() < 400)
//                        .sorted(comparing(Dish::getCalories))
//                        .map(Dish::getName)
//                        .collect(toList());
//    }
//}
