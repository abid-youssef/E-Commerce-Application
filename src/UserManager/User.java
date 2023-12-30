package UserManager;

import ProductManager.Product;

import java.util.ArrayList;

//The user class that will define users of the E-commerce application
public class User {
    private String username;
    private String password;
    private int balance;
    private UserRole role;
    private static int idCounter = 0;
    private int id;

    //this is the cart of the user that will contain the products that the user wants to purchase
    private ArrayList<Product> Cart = new ArrayList<Product>();

    // Constructor
    public User(String username, String password, UserRole role, int balance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.id= idCounter++;
    }

    //this adds a product to the cart. Not the instance of the product that is in the product management system
    //but a copy of it containing the same information as the original product except for the quantity that is the purchased quantity
    public void addToCart(Product product) {
        if (product.getQuantity() == 0) {
            System.out.println("Product is out of stock");
            return;
        }
        for(Product p : Cart) {
            if (p.getId() == product.getId()) {
                p.setQuantity(p.getQuantity() + 1);
                return;
            }
        }
        Product copyProduct = new Product(product.getName(), product.getPrice(), 1, product.getId(), product.getCategory());
        Cart.add(copyProduct);
    }
    //this removes a product as a whole from the cart. But not the instance of the product that is in the product management system
    public void removeFromCart(Product product) {
        for (Product p : Cart) {
            if (p.getId() == product.getId()) {
                Cart.remove(p);
                return;
            }
        }
    }
    public ArrayList<Product> getCart() {
        return Cart;
    }

    //enumeration of accepted user roles
    public enum UserRole {
        CUSTOMER, ADMIN
    }
    //setters and getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public UserRole getRole() {
        return role;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }
    public int getId(){
        return id;
    }
}
