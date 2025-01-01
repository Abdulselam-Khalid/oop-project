import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuthentication userAuth = new UserAuthentication();
        User loggedInUser = null;
        // Set up initial data
        ProductManager productManager = new ProductManager();

// Add products to the product manager

        Inventory inventory = new Inventory(productManager);
        CartManager cartManager = new CartManager();
        OrderManager orderManager = new OrderManager();
        DiscountManager discountManager = new DiscountManager();
        discountManager.initializeDefaultDiscounts();


        // Main loop for menu
        while (true) {
            System.out.println("==== Main Menu ====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Login
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    // Authenticate user
                    loggedInUser = userAuth.authenticateUser(username, password);

                    if (loggedInUser != null) {
                        System.out.println("Login successful!");

                        // Show menu based on role
                        if (loggedInUser.getRole().equals("admin")) {
                            showAdminMenu();
                        } else if (loggedInUser.getRole().equals("customer")) {
                            showCustomerMenu(scanner, productManager, cartManager, orderManager, discountManager, loggedInUser);
                        }
                    } else {
                        System.out.println("Invalid credentials, please try again.");
                    }
                    break;
                case 2: // Exit
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Admin menu
    public static void showAdminMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Admin Menu ====");
            System.out.println("1. View Product Reports");
            System.out.println("2. Manage Products");
            System.out.println("3. Generate Sales Reports");
            System.out.println("4. Generate Popular Products Report");
            System.out.println("5. Generate Revenue Report");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Viewing product reports...");
                    // Add functionality to view product reports
                    break;
                case 2:
                    System.out.println("Managing products...");
                    // Add functionality to manage products
                    break;
                case 3:
                    System.out.println("Generating sales reports...");
                    // Add functionality to generate sales reports
                    break;
                case 4:
                    System.out.println("Generating popular products report...");
                    // Add functionality to generate popular products report
                    break;
                case 5:
                    System.out.println("Generating revenue report...");
                    // Add functionality to generate revenue report
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Customer menu
    public static void showCustomerMenu(Scanner scanner, ProductManager productManager, CartManager cartManager,
                                        OrderManager orderManager, DiscountManager discountManager, User loggedInUser) {

        while (true) {
            System.out.println("==== Customer Menu ====");
            System.out.println("1. View Products");
            System.out.println("2. View Cart");
            System.out.println("3. Add Item to Cart");
            System.out.println("4. Remove Item from Cart");
            System.out.println("5. Apply Discount");
            System.out.println("6. Place Order");
            System.out.println("7. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Viewing products...");
                    displayProducts(productManager);
                    break;
                case 2:
                    System.out.println("Viewing cart...");
                    cartManager.viewCart();
                    break;
                case 3:
                    System.out.println("Adding item to cart...");
                    System.out.print("\nEnter product name to add: ");
                    String productNameToAdd = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantityToAdd = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Find the product
                    Product productToAdd = productManager.searchProductByName(productNameToAdd);

                    if (productToAdd == null) {
                        System.out.println("Product not found.");
                    } else if (productToAdd.getStockQuantity() < quantityToAdd) {
                        System.out.println("Insufficient stock. Available quantity: " + productToAdd.getStockQuantity());
                    } else {
                        // Add item to the cart
                        cartManager.addItemToCart(productToAdd, quantityToAdd);
                        // Deduct stock from the product
                        productToAdd.updateStock(quantityToAdd);
                        System.out.println("Added " + quantityToAdd + " of " + productToAdd.getName() + " to the cart.");
                    }
                    break;
                case 4:
                    System.out.println("Removing item from cart...");
                    // Display current items in the cart
                    cartManager.viewCart();

                    // Get the product name from the user
                    System.out.print("Enter product name to remove from cart: ");
                    String productNameToRemove = scanner.nextLine();

                    // Find the product in the cart and remove it
                    Product productToRemove = productManager.searchProductByName(productNameToRemove);
                    if (productToRemove != null) {
                        cartManager.removeItemFromCart(productToRemove);
                    } else {
                        System.out.println("Product not found in your cart.");
                    }
                    break;

                case 5:
                    System.out.println("Applying discount...");
                    System.out.print("Enter discount code: ");
                    String discountCode = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();

                    Product product = productManager.searchProductByName(productName);
                    if (product != null) {
                        if (discountManager.applyDiscount(discountCode, product)) {
                            System.out.println("Discount applied successfully!");
                            System.out.println("New price for " + product.getName() + ": " + product.getPrice());
                        } else {
                            System.out.println("Invalid discount code or discount could not be applied.");
                        }
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 6:
                    System.out.println("Placing order...");
                    // Add functionality to place order
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void manageProducts(Scanner scanner, ProductManager productManager) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nManage Products:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");
            int productChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (productChoice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter size: ");
                    String size = scanner.nextLine();
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter stock quantity: ");
                    int stockQuantity = scanner.nextInt();
                    Product newProduct = new Product(name, price, size, color, stockQuantity);
                    productManager.addProduct(newProduct);
                    System.out.println("Product added.");
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String productName = scanner.nextLine();
                    Product product = productManager.searchProductByName(productName);
                    if (product != null) {
                        productManager.removeProduct(product);
                        System.out.println("Product removed.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void generateReports() {
        Report report = new Report();
        System.out.println("\nGenerating Reports:");
        report.generateSalesReport();
        report.generatePopularProductsReport();
        report.generateRevenueReport();
    }

    public static void applyDiscount(Scanner scanner, DiscountManager discountManager, ProductManager productManager) {
        System.out.print("\nEnter product name to apply discount: ");
        String productName = scanner.nextLine();
        Product product = productManager.searchProductByName(productName);
        if (product != null) {
            System.out.print("Enter discount code: ");
            String discountCode = scanner.nextLine();
            Discount discount = discountManager.getDiscount(discountCode);
            if (discount != null) {
                discountManager.applyDiscount(discountCode, product);
                System.out.println("Discount applied to " + productName);
            } else {
                System.out.println("Discount code not found.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void placeOrder(Scanner scanner, ShoppingCartManager shoppingCartManager, OrderManager orderManager, User loggedInUser) {
        System.out.print("\nEnter shipping address: ");
        String shippingAddress = scanner.nextLine();
        Order order = new Order(loggedInUser, shoppingCartManager, shippingAddress);
        orderManager.placeOrder(order);
        System.out.println("Order placed successfully!");
        shoppingCartManager.viewCart();
    }
    // Display all products
    public static void displayProducts(ProductManager productManager) {
        System.out.println("\nProducts Available:");
        for (Product product : productManager.getAllProducts()) {
            System.out.println(product.getProductInfo());
        }
    }
}
