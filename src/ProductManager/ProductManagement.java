package ProductManager;
import UserManager.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class ProductManagement {
    private User currentUser;
    public ArrayList<Product> products;
    private Scanner scanner;
    public ArrayList<Order> Orders = new ArrayList<Order>();
    public ProductManagement(User currentUser) {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);
        this.currentUser = currentUser;
    }

    //this is the admin menu
    public void adminStart() {
        System.out.println("Welcome to the Product Management System!");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Create ProductManager.Product");
            System.out.println("2. Read/View Products");
            System.out.println("3. Update ProductManager.Product");
            System.out.println("4. Delete ProductManager.Product");
            System.out.println("5. View Orders");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    //adds product to system
                    ProductCRUD.addProduct(products);
                    break;
                case 2:
                    //shows products in system
                    ProductCRUD.viewProducts(products);
                    break;
                case 3:
                    //updates product in system
                    ProductCRUD.updateProduct(products);
                    break;
                case 4:
                    //removes product from system
                    ProductCRUD.removeProduct(products);
                    break;
                case 5:
                    //shows orders in system
                    if (Orders.isEmpty()) {
                        System.out.println("No orders yet");
                        break;
                    }
                    else {
                        for (Order order : Orders) {
                            System.out.println(order.toString());
                        }
                        break;
                    }
                case 6:
                    System.out.println("Thank you for using the Product Management System!");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    //this is the customer menu
    public void customerStart() {
        System.out.println("Welcome to the ProductManager.Product Management System!");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. View Products");
            System.out.println("2. Add ProductManager.Product to Cart");
            System.out.println("3. Remove ProductManager.Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Buy Products");
            System.out.println("6. Rate ProductManager.Product");
            System.out.println("7. View ratings");
            System.out.println("8. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    //shows products in system
                    ProductCRUD.viewProducts(products);
                    break;
                case 2:
                    //adds product to cart after checking if it exists in the system
                    System.out.println("Please enter the product id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    int check= 0;
                    for (Product product : products) {
                        if (product.getId() == id) {
                            currentUser.addToCart(product);
                            System.out.println("Product added to cart successfully!");
                            check=1;
                            break;
                        }
                    }
                    if(check==0)
                    {
                        System.out.println("Product not found in system, Invalid id");
                    }
                    break;
                case 3:
                    //removes product from cart after checking if it exists in the cart
                    System.out.println("Please enter the product id:");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    int check2=0;
                    for (Product product : currentUser.getCart()) {
                        if (product.getId() == id) {
                            currentUser.removeFromCart(product);
                            System.out.println("Product removed from cart successfully!");
                            check2=1;
                            break;
                        }
                    }
                    if(check2==0){
                        System.out.println("Product not found in cart");
                    }
                    break;
                case 4:
                    //shows products in cart with their respective quantities
                    if (currentUser.getCart().isEmpty()) {
                        System.out.println("Cart is empty");
                        break;
                    }
                    for (Product product : currentUser.getCart()) {
                        System.out.println(product.toString());
                    }
                    break;
                case 5:
                    //executes the purchase transaction
                    buyProducts();
                    break;
                case 6:
                    //rates a product
                    RatingSystem.rateProduct(products);
                    break;
                case 7:
                    //shows ratings of products
                    RatingSystem.viewRatings(products);
                    break;
                case 8:
                    currentUser.getCart().clear();
                    System.out.println("Thank you for using the Product Management System!");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    //this is the buy method that executes the purchase transaction from the system
    private void buyProducts(){
        //check if cart is empty
        if(currentUser.getCart().isEmpty()){
            System.out.println("Cart is empty");
            return;
        }
        //calculate total price
        int totalPrice = 0;
        for(Product product : currentUser.getCart()){
            totalPrice += product.getPrice() * product.getQuantity();
        }
        System.out.println("Total price: " + totalPrice);
        if(currentUser.getBalance() < totalPrice){
            System.out.println("Insufficient funds");
            return;
        }
        //check if products are in stock
        for(Product product : currentUser.getCart()){
            for(Product p : products){
                if(product.getId() == p.getId()){
                    if(p.getQuantity() < product.getQuantity()){
                        System.out.println("Product " + p.getName() + " is out of stock");
                        return;
                    }
                    p.setQuantity(p.getQuantity() - product.getQuantity());
                }
            }
        }
        //update balance and clear cart after checks
        currentUser.setBalance(currentUser.getBalance() - totalPrice);
        //logs date and order
        Date currentDate=Order.DateInput();
        Order.Status status=Order.StatusInputMenu();
        for(Product product : currentUser.getCart()){
            Orders.add(new Order(product.getQuantity(), product.getPrice(), product.getId(), currentUser.getId(), currentDate, status));
        }

        currentUser.getCart().clear();
        System.out.println("Products Purchased successfully!");

    }

    //setters and getters
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void addOrder(Order order) {
        Orders.add(order);
    }

    public void start() {
        if (currentUser.getRole() == User.UserRole.ADMIN) {
            adminStart();
        } else {
            customerStart();
        }
    }
}
