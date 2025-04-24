package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class SearchInventory {

    private static final Scanner input = new Scanner(System.in);
    private static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(" Welcome to Dawgs Comictorium!");
        inventory = getInventory();
        sortInventoryByName();
        runMenu();
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        try {
            File file = new File("inventory.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    inventory.add(new Product(id, name, price));
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            // Items
            inventory.add(new Product("5", "Silver Surfer Complete Edition(Stan Lee)", 12.99));
            inventory.add(new Product("1", "Absolute Batman: Issues 1-5", 10.00));
            inventory.add(new Product("3", "House of M: Issues 1-10", 17.49));
            inventory.add(new Product("2", "Daredevil (Frank Miller): Issues 1-20", 21.99));
            inventory.add(new Product("4", "Injustice: Complete Edition", 29.99));
        }

        return inventory;
    }

    public static void sortInventoryByName() {
        inventory.sort(Comparator.comparing(Product::getName));
    }

    public static void runMenu() {
        int command = 0;

        while (command != 5) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");
            System.out.print("Enter command: ");

            command = Integer.parseInt(input.nextLine());

            switch (command) {
                case 1:
                    listAllProducts();
                    break;
                case 2:
                    lookupById();
                    break;
                case 3:
                    findByPriceRange();
                    break;
                case 4:
                    addNewProduct();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    public static void listAllProducts() {
        sortInventoryByName();
        System.out.println("\nStore Inventory:");
        for (Product p : inventory) {
            System.out.println(p);
        }
    }

    public static void lookupById() {
        System.out.print("Enter the product ID: ");
        String id = input.nextLine().trim();

        boolean found = false;
        for (Product p : inventory) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    public static void findByPriceRange() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(input.nextLine());
        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(input.nextLine());

        System.out.println("Products between $" + min + " and $" + max + ":");

        boolean found = false;
        for (Product p : inventory) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found in that price range.");
        }
    }

    public static void addNewProduct() {
        System.out.print("Enter product ID: ");
        String id = input.nextLine().trim();
        System.out.print("Enter product name: ");
        String name = input.nextLine().trim();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(input.nextLine());

        inventory.add(new Product(id, name, price));
        System.out.println("Product added successfully.");
    }
}