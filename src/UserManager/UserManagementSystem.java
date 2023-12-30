package UserManager;

import ProductManager.ProductManagement;

import java.util.Scanner;
import java.util.ArrayList;
public class UserManagementSystem {
    //arraylist of users
    private ArrayList<User> users;
    private User currentUser;
    private Scanner scanner;
    ProductManagement productManagement = new ProductManagement(currentUser);
    //constructor
    public UserManagementSystem() {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);

    }
    //this is the main login menu
    public void start() {
        System.out.println("Welcome to the User Management System!");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Thank you for using the User Management System!");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    //this is the login method that checks if the user does exists in the system
    private void login() {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful!");
                productManagement.setCurrentUser(currentUser);
                productManagement.start();
                return;
            }
        }
        System.out.println("Invalid username or password");
    }

    //this is the register method that checks if the user already exists in the system
    private void register() {
        try {
            System.out.println("Please enter your username:");
            String username = scanner.nextLine();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username already exists");
                    return;
                }
            }
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();
            if (password.length() < 8) {
                System.out.println("Password must be at least 8 characters long");
                return;}

            System.out.println("Please enter your role: \n 1. Customer \n 2. Admin");
            int rol = scanner.nextInt();
            String role= rol==1 ? "Customer" : "Admin";
            System.out.println("Please enter your balance:");
            int balance = scanner.nextInt();
            scanner.nextLine();
            User newUser = new User(username, password, User.UserRole.valueOf(role.toUpperCase()), balance);
            users.add(newUser);
            System.out.println("UserManagement.User registered successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.nextLine(); // Clear the buffer to avoid an infinite loop
        }
    }
    //getters and setters
    public User getCurrentUser() {
        return currentUser;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public void addUser(User user){
        users.add(user);
    }
    public ProductManagement getProductManagement(){
        return productManagement;
    }
}