package com.ecommerce;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static DataStore dataStore = new DataStore();
    private static StoreService storeService = new StoreService(dataStore);
    private static User currentUser = null;

    public static void main(String[] args) {
        boolean exit = false;

        System.out.println("============================================");
        System.out.println("      Welcome to Java E-Commerce Store      ");
        System.out.println("============================================");

        while (!exit) {
            if (currentUser == null) {
                showGuestMenu();
                int choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1 -> handleRegister();
                    case 2 -> handleLogin();
                    case 0 -> {
                        System.out.println("Goodbye!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } else {
                showUserMenu();
                int choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1 -> storeService.listProducts();
                    case 2 -> handleAddToCart();
                    case 3 -> storeService.viewCart();
                    case 4 -> storeService.checkout(currentUser.getUsername());
                    case 5 -> handleLogout();
                    case 0 -> {
                        System.out.println("Goodbye!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
        }
    }

    private static void showGuestMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
    }

    private static void showUserMenu() {
        System.out.println("\n=== User Menu (Logged in as: " + currentUser.getUsername() + ") ===");
        System.out.println("1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Logout");
        System.out.println("0. Exit");
    }

    private static void handleRegister() {
        System.out.println("\n=== Register ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        if (dataStore.findUserByUsername(username) != null) {
            System.out.println("Username already exists. Try another.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        User newUser = new User(username, password);
        dataStore.addUser(newUser);
        System.out.println("Registration successful. You can now login.");
    }

    private static void handleLogin() {
        System.out.println("\n=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        User user = dataStore.findUserByUsername(username);
        if (user == null || !user.checkPassword(password)) {
            System.out.println("Invalid username or password.");
        } else {
            currentUser = user;
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
        }
    }

    private static void handleLogout() {
        System.out.println("Logged out: " + currentUser.getUsername());
        currentUser = null;
    }

    private static void handleAddToCart() {
        System.out.println("\n=== Add to Cart ===");
        storeService.listProducts();
        int productId = readInt("Enter product ID: ");
        int qty = readInt("Enter quantity: ");
        storeService.addToCart(productId, qty);
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
