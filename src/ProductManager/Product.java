package ProductManager;

import java.util.Scanner;
import java.util.ArrayList;
public class Product{
    private String name;
    private int price;
    private int quantity;
    private Scanner scanner = new Scanner(System.in);
    private int id;
    private static int idCounter = 0;
    private Category category;
    //Ratings for the product
    public ArrayList<String> Ratings = new ArrayList<String>();
    public Product(String name, int price, int quantity, Category category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = idCounter++;
        this.category = category;
    }
    public Product(String name, int price, int quantity, int id, Category category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }
    public String getName(){
        return name;
    }

    public void addRating(String rating){
        Ratings.add(rating);
    }
    public ArrayList<String> getRatings(){
        return Ratings;
    }
    public void showRatings(){
        if (Ratings.isEmpty()){
            System.out.println("No ratings yet");
            return;
        }
        for(String rating : Ratings){
            System.out.println(rating);
        }
    }
    public int getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setId(int id){
        this.id = id;
    }
    public String toString(){
        return "Product: " + name + " Price: " + price + " Quantity: " + quantity + " ID: " + id + " Category: " + category;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public enum Category{
        FOOD,
        ELECTRONICS,
        CLOTHING,
        HEALTH,
        BEAUTY,
        SPORTS,
        HOME,
        OTHER
    }
}



