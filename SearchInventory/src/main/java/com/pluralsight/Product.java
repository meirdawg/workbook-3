package com.pluralsight;

public class Product {
    private String id;
    private String name;
    private double price;
    private double issue;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.issue = issue;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | $" + String.format("%.2f", price);
    }
}
