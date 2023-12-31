# E-Commerce-Application
*This is my attempt at simulating the E-Commerce Application which was assigned to us in the OOP java course*

## Features + Implementation choices

### 1. **User authentication + Login System**:
- Two account types (Customer and Admin) with different menus and features for each
- Sign up menu for creating a new account and a sign in menu for already created accounts
- The ability to switch between accounts in the same session

### 2. **Product management + Special feature**: 
- The products contain the adequate and different variables associated with a product including their respective quantities
- The category of a product is simply an attribute of the product class instead of having multiple classes inherit the product class. To make sure that this is stable and well integrated, the categories are enumerated into already set possible choices including but not limited to Foods, sports, beauty, tech, and others
- The products also contain an optional attribute that is an Arraylist of strings used to integrate an additional feature: **User recommendations and ratings** for that specific product. The user menu contains options to rate a product and view ratings for products.

### 3. **Product storage + Shopping cart**:
- The products in stock are saved in an Arraylist of products
- The shopping cart is simply an Arraylist of products that is an attribute to each user instance and is emptied as soon as the customer chooses to leave the product management system.
- Since quantities are an inherent property of the product instance, to avoid a clash between the products in the management system and in the shopping carts, a copy of each ordered product is placed in the shopping cart with its ordered quantity stored in its quantity attribute
- The stock quantities of the products in the product management system are only verified and changed when the user has gone through the purchase process and verification for their balance. This was done to avoid unnecessary stock manipulation when the products are not purchased for sure yet.

### 4. **Product manipulation**:
- This is managed by the product management system that gives calls to multiple classes depending on the need
- Product manipulation includes CRUD operations, dynamic search by name and filtering by category.

### 5. **Orders + Special features**: 
- The orders are also stored as an Arraylist of Order instances made for each order placed by a customer and they can later be viewed by an administrator
- An additional feature with these orders is that they contain the **date and time** of the placed order which is requested after the customer chooses to go forward with the purchase. The date input has a specific format which is facilitated and verified by 'java.text.SimpleDateFormat' in conjunction with java.text.ParseException.
- An order is unique to each customer and product, to handle this with the cart system, a unique order is placed for each item in the shopping cart with the same user and inputted date when a purchase is made.
- The order class also contains the status which is one of the additional features, **shipping option** that is chosen by the customer upon purchase and enumerated Express and Normal options.

*-The rest of the requested features were also implemented but their code needs no further elaboration due to their straightforward nature*

## Usage

```bash
git clone https://github.com/abid-youssef/E-Commerce-Application.git
```
Then you can simply run the main.java to test the program

*if any issues are faced in cloning the repo or similar issues, please contact me and I will make sure to respond as soon as possible.*

##

 ***Note:***
*This project was made with some assistance from AI tools and companions such as Github Copilot and ChatGPT but they had no influence in the design choices and planning. It was also coded in full in the JetBrains IntelliJ IDEA Environment*
