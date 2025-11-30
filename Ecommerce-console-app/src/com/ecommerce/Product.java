package com.ecommerce;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int qty) {
        this.stock -= qty;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-20s Rs.%-10.2f Stock:%d", id, name, price, stock);
    }
}
