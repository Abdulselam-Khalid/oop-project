public class ShoppingCartManager extends ShoppingCart {
    private ShoppingCart shoppingCart;

    public ShoppingCartManager() {
        shoppingCart = new ShoppingCart();
    }

    public void addItem(Product product, int quantity) {
        shoppingCart.addItem(product, quantity);
    }

    public void removeItem(Product product) {
        shoppingCart.removeItem(product);
    }

    public void viewCart() {
        shoppingCart.displayCart();
    }

    public double getTotalAmount() {
        return shoppingCart.getTotalPrice();
}
}
