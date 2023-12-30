package ProductManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Order {
    private int id;
    private int quantity;
    private int price;
    private int productId;
    private int userId;
    private Date transactionDate;
    private Status status;
    private static int idCounter = 0;
    private static Scanner scanner = new Scanner(System.in);

    //constructor
    public Order(int quantity, int price, int productId, int userId, Date transactionDate, Status status) {
        this.transactionDate = transactionDate;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.userId = userId;
        this.id = idCounter++;
        this.status = status;
    }
    public Order(int quantity, int price, int productId, int userId, String Date, Status status) throws ParseException {
        // This defines the wanted date format "yyyy-MM-dd HH:mm"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // This parses the input string to a Date object
        transactionDate = dateFormat.parse(Date);
        this.transactionDate = transactionDate;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.userId = userId;
        this.id = idCounter++;
        this.status = status;
    }

    //setters and getters
    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //returns order info
    public String toString() {
        return "ProductManager.Order ID: " + id + " Quantity: " + quantity + " Price: " + price + " ProductManager.Product ID: " + productId + " UserManagement.User ID: " + userId + " Transaction Date: " + transactionDate+ " Status: " + status;
    }

    //Date Input function
    public static Date DateInput() {
        Date transactionDate;

        Scanner scanner = new Scanner(System.in);
        // Loop until a valid date is entered
        while (true) {
            System.out.println("Enter the transaction date (format: yyyy-MM-dd HH:mm):");
            String dateString = scanner.nextLine();
            try {
                // This defines the wanted date format "yyyy-MM-dd HH:mm"
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                // This parses the input string to a Date object
                transactionDate = dateFormat.parse(dateString);
                // Breaks out of the loop if parsing is successful
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return transactionDate;
    }
    //status input function
    public static Status StatusInputMenu(){
        System.out.println("Please select the shipping option:");
        System.out.println("EXPRESS");
        System.out.println("NORMAL");
        String statusInput = scanner.nextLine();
        try {
            return Status.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status");
            return StatusInputMenu();
        }
    }
    //status enum
    public enum Status {
        EXPRESS,
        NORMAL,
    }
}
