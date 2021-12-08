package com.pondit.b4.class12.builderPattern;

public class Cake {
    private final double sugar;
    private final double butter;
    private final double milk;
    private final int cherry;


    private Cake(CakeBuilder cakeBuilder) {
        this.sugar = cakeBuilder.sugar;
        this.butter = cakeBuilder.butter;
        this.milk = cakeBuilder.milk;
        this.cherry = cakeBuilder.cherry;
    }

    public static class CakeBuilder {

        private double sugar;
        private double butter;
        private double milk;
        private int cherry;

        public CakeBuilder sugar(double spoon) {
            this.sugar = spoon;
            return this;
        }

        public CakeBuilder butter(double spoon) {
            this.butter = spoon;
            return this;
        }

        public CakeBuilder milk(double cup) {
            this.milk = cup;
            return this;
        }

        public CakeBuilder cherry(int count) {
            this.cherry = count;
            return this;
        }

        public Cake build() {
            return new Cake(this);
        }
    }

    @Override
    public String toString() {
        return "Cake{" +
                (sugar == 0 ? "" : "sugar=" + sugar + ",") +
                " butter=" + butter +
                ", milk=" + milk +
                ", cherry=" + cherry +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        Cake cake = new Cake.CakeBuilder()
                .cherry(2)
//                .sugar(1)
                .butter(2)
                .milk(4)
                .build();
        System.out.println(cake);
    }
}