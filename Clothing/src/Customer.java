public class Customer extends User {
    private ShoppingCart shoppingCart;

    public Customer(String username, String password, String email, String address) {
        super(username, password, email, address, "customer");
        shoppingCart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void placeOrder(String shippingAddress) {
        // Logic to place an order
}
}
