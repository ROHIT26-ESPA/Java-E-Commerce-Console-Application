package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class StoreService {

    private DataStore dataStore;
    private List<CartItem> cart;

    public StoreService(DataStore dataStore) {
        this.dataStore = dataStore;
        this.cart = new ArrayList<>();
    }

    public void listProducts() {
        System.out.println("\nAvailable Products:");
        System.out.println("ID  Name                 Price      Stock");
        System.out.println("------------------------------------------------");
        for (Product p : dataStore.getProducts()) {
            System.out.println(p);
        }
    }

    public boolean addToCart(int productId, int quantity) {
        Product product = dataStore.findProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return false;
        }
        if (product.getStock() < quantity) {
            System.out.println("Not enough stock available.");
            return false;
        }

        // reduce stock in store
        product.reduceStock(quantity);

        // add to cart
        cart.add(new CartItem(product, quantity));
        System.out.println("Added to cart: " + product.getName() + " x " + quantity);
        return true;
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        System.out.println("\nYour Cart:");
        double total = 0.0;
        for (CartItem item : cart) {
            System.out.println("- " + item);
            total += item.getTotalPrice();
        }
        System.out.println("------------------------------------------------");
        System.out.println("Total: Rs." + String.format("%.2f", total));
    }

    public void clearCart() {
        cart.clear();
    }

    public boolean checkout(String username) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add items before checkout.");
            return false;
        }
        double total = 0.0;
        for (CartItem item : cart) {
            total += item.getTotalPrice();
        }

        System.out.println("\n=== Order Summary ===");
        System.out.println("Customer: " + username);
        for (CartItem item : cart) {
            System.out.println(item);
        }
        System.out.println("Total Amount: Rs." + String.format("%.2f", total));
        System.out.println("Thank you for shopping with us!");

        // here you could save the order to file / DB
        clearCart();
        return true;
    }
}
