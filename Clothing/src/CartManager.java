public class CartManager {
    public ShoppingCart cart;

    public CartManager() {
        cart = new ShoppingCart();
    }

    public void addItemToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }

    public void removeItemFromCart(Product product) {
        CartItem itemToRemove = null;

        // Find the item in the cart
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().equals(product)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            // Restore the stock
            product.removedStock(itemToRemove.getQuantity());

            // Remove the item from the cart
            cart.getItems().remove(itemToRemove);

            System.out.println("Removed " + itemToRemove.getQuantity() + " of " + product.getName() + " from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    public void viewCart() {
        cart.displayCart();
    }

    public double getTotalPrice() {
        return cart.getTotalPrice();
    }
}
