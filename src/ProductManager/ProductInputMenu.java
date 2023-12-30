package ProductManager;

import ProductManager.Product;

import java.util.Scanner;
public class ProductInputMenu {
    private static Scanner scanner = new Scanner(System.in);

    //category input method
    public static Product.Category CategoryInput() {
        System.out.println("Please select the product category:");
        for (Product.Category category : Product.Category.values()) {
            System.out.println(category.name());
        }
        String categoryInput = scanner.nextLine();
        try {
            Product.Category category = Product.Category.valueOf(categoryInput.toUpperCase());
            return category;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category");
            return CategoryInput();
        }
    }
    //ProductManager.Product Input method
    public static Product ProductInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the product name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the product price:");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the product quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Product.Category Category = CategoryInput();
        return new Product(name, price, quantity, Category);
    }
}

