package com.pondit.b4.class30_31;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;

// 1. Find out 3 products with maximum ratings. Sort products by (i) product ratings. If more than 1 products have same amount of ratings, (ii) sort by names
// 2. Find out 3 products with minimum ratings. Sort products by (i) product ratings. If more than 1 products have same amount of ratings, (ii) sort by names
// 3. Find out total orders of each specific kind of product
// 4. Find out customer 1's favorite product. A favorite product is the maximum quantity a customer ordered of a specific product
// 5. Calculate the total cost of a order for a customer (Customer 1, 2nd order)
// 6. Find out all books written by each author

public class StreamPractice {

    static Customer customer1 = new Customer();
    static Customer customer2 = new Customer();
    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        init();
//        System.out.println("============ Testing map()  ==============");
//        customer1
//                .getOrders().stream()
//                .map(Order::getItems)
//                .forEach(System.out::println);
//
//        System.out.println("============ Testing flatMap() ==============");
//
//        customer1
//                .getOrders().stream()
//                .map(Order::getItems)
//                .flatMap(Collection::stream)
//                .forEach(System.out::println);

        // TODO: 1. Find out 3 products with maximum ratings.
        //  Sort products by (i) product ratings. If 2 products have same amount of ratings, (ii) sort by names

        var setOfProduct = customer1
                .getOrders().stream()
                .map(Order::getItems).flatMap(Collection::stream).collect(Collectors.toSet());

        System.out.println("\n=========== Products with Maximum ratings ============");
        setOfProduct.stream()
                .sorted(
                        Comparator.comparing(Product::getRating)
                                .reversed()
                                .thenComparing(Product::getName)
                )
                .limit(3)
                .forEach(System.out::println);

        // TODO: 2. Find out 3 products with minimum ratings.
        //  Sort products by (i) product ratings. If 2 products have same amount of ratings, sort by names

        System.out.println("\n=========== Products with Minimum ratings ============");
        setOfProduct.stream()
                .sorted(
                        Comparator.comparing(Product::getRating)
                                .thenComparing(Product::getName)
                )
                .limit(3)
                .forEach(System.out::println);

        // TODO: 3. Find out total orders of each specific kind of product
        var customer1Orders = customer1.getOrders().stream()
                .flatMap(order -> order.getItems().stream()).toList();
        var customer2Orders = customer2.getOrders().stream()
                .flatMap(order -> order.getItems().stream()).toList();

//        System.out.println("\n============== Testing merged streams =============");
//        Stream.concat(customer1Orders.stream(), customer2Orders.stream()).forEach(System.out::println);

        System.out.println("\n============== Find out total orders of each specific kind of product =============");
        Stream.concat(customer1Orders.stream(), customer2Orders.stream())
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()))
                .entrySet().forEach(System.out::println);

        // TODO: 4. Find out customer 1's favorite product.
        //  A favorite product is the maximum quantity a customer ordered of a specific product
        System.out.println("\n============== Customer 1's favorite product =============");
        var productsMap = customer1Orders.stream()
                .collect(Collectors.groupingBy(Product::getName, TreeMap::new, Collectors.counting()));
        productsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

        // TODO: 5. Calculate the total cost of a order for a customer (customer 1, 2nd order)
        System.out.println("\n============= Calculate the total cost of a order for a customer =============");
        var total = customer1.getOrders().get(0)
                .getItems().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(total);

        // TODO: 6. Find out all books written by each author
        System.out.println("\n============= Find out all books written by each author =============");
        products.stream()
                .collect(Collectors.groupingBy(Product::getAuthor, Collectors.toList()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }

    private static FavoriteProduct getFavoriteProduct(Map.Entry<String, Long> stringLongEntry) {
        FavoriteProduct fav = new FavoriteProduct();
        fav.setProductCount(stringLongEntry.getValue());
        fav.setProductName(stringLongEntry.getKey());
        return fav;
    }

    private static void init() {
        Product product = new Product();
        product.setName("Java Programming I");
        product.setPrice(BigDecimal.valueOf(700));
        product.setAuthor("A.N.M. Bazlur Rahman");
        product.setRating(10);

        Product product1 = new Product();
        product1.setName("Java Programming II");
        product1.setPrice(BigDecimal.valueOf(300));
        product1.setAuthor("A.N.M. Bazlur Rahman");
        product1.setRating(9);

        Product product2 = new Product();
        product2.setName("Thread Programming");
        product2.setPrice(BigDecimal.valueOf(250));
        product2.setAuthor("A.N.M. Bazlur Rahman");
        product2.setRating(9);

        Product product3 = new Product();
        product3.setName("Sun Java 2");
        product3.setAuthor("Unknown Author");
        product3.setPrice(BigDecimal.valueOf(250));
        product3.setRating(7);

        products = List.of(product, product1, product2, product3);

        Order order1 = new Order();
        order1.setOrderId(UUID.randomUUID().toString());

        order1.setItems(new ArrayList<>());
        order1.getItems().add(product);
//        order1.getItems().add(product1);
//        order1.getItems().add(product2);
        order1.getItems().add(product3);

        Order order2 = new Order();
        order2.setOrderId(UUID.randomUUID().toString());
        order2.setItems(new ArrayList<>());
        order2.getItems().add(product3);
        order2.getItems().add(product1);
        order2.getItems().add(product);

        Order order3 = new Order();
        order3.setOrderId(UUID.randomUUID().toString());
        order3.setItems(new ArrayList<>());
        order3.getItems().add(product2);
        order3.getItems().add(product);
        order3.getItems().add(product1);

        Order order4 = new Order();
        order4.setOrderId(UUID.randomUUID().toString());
        order4.setItems(new ArrayList<>());
        order4.getItems().add(product3);
        order4.getItems().add(product1);
        order4.getItems().add(product2);

        customer1.setCustomerName("Mainul");
        List<Order> orders1 = new ArrayList<>();
        orders1.add(order1);
        orders1.add(order3);
        customer1.setOrders(orders1);

        customer2.setCustomerName("Hasan");
        List<Order> orders2 = new ArrayList<>();
        orders2.add(order2);
        orders2.add(order4);
        customer2.setOrders(orders2);
    }
}

class FavoriteProduct {
    private String productName;
    private Long productCount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    @Override public String toString() {
        return "FavoriteProduct{" + "productName='" + productName + '\'' + ", productCount=" + productCount + '}';
    }
}

class Customer {
    private String customerName;
    private List<Order> orders;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override public String toString() {
        return "Customer{" + "customerName='" + customerName + '\'' + ", orders=" + orders + '}';
    }
}

class Order {
    private List<Product> items;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override public String toString() {
        return "Order{" + "items=" + items + ", orderId='" + orderId + '\'' + '}';
    }
}

class Product {
    private String name;
    private BigDecimal price;
    private int rating;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + ", rating=" + rating + '}';
    }
}