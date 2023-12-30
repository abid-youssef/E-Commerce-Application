package ProductManager;

import ProductManager.Product;

import java.util.ArrayList;
import java.util.Scanner;
public class ProductSearchAndFiltering {
    private static Scanner scanner = new Scanner(System.in);
    //this is the search method that searches for a product in the system
    public static void searchProduct(ArrayList<Product> products) {
        System.out.println("Please enter the product name:");
        String name = scanner.nextLine().toUpperCase();
        int check = 1;
        for (Product product : products) {
            if ((product.getName().toUpperCase()).equals(name)) {
                System.out.println(product.toString());
                check = 0;
                return;
            }
        }
        if (check == 1) {
            System.out.println("Product not found");
        }
    }
    //this is the filter method that filters products by category
    public static void filterProduct(ArrayList<Product> products) {
        System.out.println("Please enter the product category:");
        String category = scanner.nextLine().toUpperCase();
        int check = 1;
        for (Product product : products) {
            if (product.getCategory().toString().equals(category)) {
                System.out.println(product.toString());
                check = 0;
            }
        }
        if (check == 1) {
            System.out.println("Products not found");
        }
    }
}