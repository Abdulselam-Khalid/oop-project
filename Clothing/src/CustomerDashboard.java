public class CustomerDashboard {
    private Customer customer;

    public CustomerDashboard(Customer customer) {
        this.customer = customer;
    }

    public void viewCart() {
        System.out.println("Viewing customer cart...");
        // Display cart items
    }

    public void placeOrder() {
        System.out.println("Placing order...");
        // Logic to place an order
}
}