package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public DataStore() {
        seedProducts();
        seedUsers();
    }

    private void seedProducts() {
        products.add(new Product(1, "Laptop", 55000.00, 10));
        products.add(new Product(2, "Smartphone", 22000.00, 25));
        products.add(new Product(3, "Headphones", 2500.00, 50));
        products.add(new Product(4, "Keyboard", 1200.00, 40));
        products.add(new Product(5, "Mouse", 800.00, 60));
    }

    private void seedUsers() {
        // Demo user
        users.add(new User("admin", "admin123"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<User> getUsers() {
        return users;
    }

    public Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public User findUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) return u;
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
