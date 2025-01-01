public class CartValidation {
    private Inventory inventory;

    public CartValidation(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean validateCart(ShoppingCart cart) {
        for (CartItem item : cart.getItems()) {
            if (!inventory.isProductAvailable(item.getProduct(), item.getQuantity())) {
                return false;
            }
        }
        return true;
}
}