package ProductManager;

import ProductManager.Product;

import java.util.ArrayList;
import java.util.Scanner;
public class RatingSystem {
    private static Scanner scanner = new Scanner(System.in);
    //this is the rate method that rates a product
    public static void rateProduct(ArrayList<Product> products) {
        System.out.println("Please enter the product id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        int check = 1;
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("Please enter your rating:");
                String rating = scanner.nextLine();
                product.Ratings.add(rating);
                System.out.println("Product rated successfully!");
                check = 0;
                return;
            }
        }
        if (check == 1) {
            System.out.println("Product not found");
        }
    }
    //this is the view rating method that shows the ratings of a product
    public static void viewRatings(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println("Product name: " + product.getName());
            if (product.Ratings.isEmpty()) {
                System.out.println("No ratings yet");
                continue;
            }
            System.out.println("Ratings:");
            for (String rating : product.Ratings) {
                System.out.println(rating);
            }
        }
    }
}

