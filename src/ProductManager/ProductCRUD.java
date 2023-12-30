package ProductManager;

import java.util.Scanner;
import java.util.ArrayList;
public class ProductCRUD {
    static Scanner scanner = new Scanner(System.in);

    //this is the view products method that shows all the products in the system
    public static void viewProducts(ArrayList<Product> products) {
        //check if there are any products in the system
        if (products.isEmpty()) {
            System.out.println("No products yet");
            return;
        }
        //switch case for viewing products by category, name, or just view all
        System.out.println("Please select an option:");
        System.out.println("1. View all products");
        System.out.println("2. View products by category");
        System.out.println("3. View products by name");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                for (Product product : products) {
                    System.out.println(product.toString());
                }
                break;
            case 2:
                ProductSearchAndFiltering.filterProduct(products);
                break;
            case 3:
                ProductSearchAndFiltering.searchProduct(products);
                break;
            default:
                System.out.println("Invalid option");
        }


    }
    //this is the add product method that adds a product to the system
    public static void addProduct(ArrayList<Product> products) {
        Product product = ProductInputMenu.ProductInput();
        for(Product p : products){
            if(p.getName().equals(product.getName())){
                System.out.println("Product already exists");
                return;
            }
        }
        products.add(product);
        System.out.println("Product added successfully!");
    }

    //this is the remove product method that removes a product from the system
    public static void removeProduct( ArrayList<Product> products) {
        System.out.println("Please enter the product id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                System.out.println("Product removed successfully!");
                return;
            }
        }
        System.out.println("Product not found");
    }
    //this is the update product method that updates a product in the system
    public static void updateProduct(ArrayList<Product> products) {
        System.out.println("Please enter the product id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        int check = 1;
        for (Product product : products) {
            if (product.getId() == id) {
                //take in new product details
                System.out.println("Please enter the new product details:");
                Product updatedProduct = ProductInputMenu.ProductInput();
                //set the new values with an unchanged id
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setQuantity(updatedProduct.getQuantity());
                product.setCategory(updatedProduct.getCategory());
                System.out.println("Product updated successfully!");
                check = 0;
                return;

            }
        }
        if (check == 1) {
            System.out.println("Product not found");
        }
    }
}
