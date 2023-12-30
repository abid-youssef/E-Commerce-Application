import ProductManager.Order;
import ProductManager.Product;
import UserManager.UserManagementSystem;
import UserManager.User;
import java.text.ParseException;


public class Main {
    // start the system
    private static void SystemStart(UserManagementSystem userManagementSystem){
        try {
            System.out.println("......................Starting new session......................");
            userManagementSystem.start();
        }
        catch (Exception e) {
            System.out.println("Invalid input---Please try again");
        }

    }

    public static void main(String[] args) throws ParseException {


        UserManagementSystem userManagementSystem = new UserManagementSystem();

        // add some default users
        userManagementSystem.addUser(new User("admin", "admin", User.UserRole.ADMIN, 0));
        userManagementSystem.addUser(new User("user", "user", User.UserRole.CUSTOMER, 100));

        // add some default products
        userManagementSystem.getProductManagement().addProduct(new Product("Banana", 5, 100, Product.Category.FOOD));
        userManagementSystem.getProductManagement().addProduct(new Product("Apple", 10, 100, Product.Category.FOOD));
        userManagementSystem.getProductManagement().addProduct(new Product("Galaxy", 100, 100, Product.Category.ELECTRONICS));
        userManagementSystem.getProductManagement().addProduct(new Product("iPhone", 200, 100, Product.Category.ELECTRONICS));
        userManagementSystem.getProductManagement().addProduct(new Product("Nike", 200, 100, Product.Category.CLOTHING));
        userManagementSystem.getProductManagement().addProduct(new Product("Adidas", 150, 100, Product.Category.CLOTHING));
        userManagementSystem.getProductManagement().addProduct(new Product("Mask", 10, 100, Product.Category.HEALTH));
        userManagementSystem.getProductManagement().addProduct(new Product("Shampoo", 20, 100, Product.Category.BEAUTY));
        userManagementSystem.getProductManagement().addProduct(new Product("Soap", 5, 100, Product.Category.BEAUTY));
        userManagementSystem.getProductManagement().addProduct(new Product("Ball", 50, 100, Product.Category.SPORTS));
        userManagementSystem.getProductManagement().addProduct(new Product("Racket", 100, 100, Product.Category.SPORTS));

        // add some default Ratings
        userManagementSystem.getProductManagement().getProducts().get(0).addRating("Average sized");
        userManagementSystem.getProductManagement().getProducts().get(1).addRating("Kept the doctor away :D");
        userManagementSystem.getProductManagement().getProducts().get(2).addRating("Way too fragile!");
        userManagementSystem.getProductManagement().getProducts().get(2).addRating("Highly recommend");
        userManagementSystem.getProductManagement().getProducts().get(3).addRating("Expensive!");
        userManagementSystem.getProductManagement().getProducts().get(3).addRating("Premium quality");
        userManagementSystem.getProductManagement().getProducts().get(4).addRating("Good quality, didn't dig the look that much though");

        // add some default orders

        userManagementSystem.getProductManagement().addOrder(new Order(10, 10, 1, 1, "2021-05-01 16:19", Order.Status.EXPRESS));
        userManagementSystem.getProductManagement().addOrder(new Order(10, 150, 5, 1, "2021-05-01 16:20", Order.Status.EXPRESS));


        //this is implemented to catch any uncaught exceptions
        SystemStart(userManagementSystem);

    }
}
