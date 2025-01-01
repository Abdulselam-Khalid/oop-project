import java.util.ArrayList;
import java.util.List;

    public class ShoppingCart {
        private List<CartItem> items;

        public ShoppingCart() {
            items = new ArrayList<>();
        }

        public void addItem(Product product, int quantity) {
            items.add(new CartItem(product, quantity));
        }

        public void removeItem(Product product) {
            items.removeIf(item -> item.getProduct().equals(product));
        }

        public double getTotalPrice() {
            return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
        }

        public List<CartItem> getItems() {
            return items;
        }

        public void displayCart() {
            System.out.println("Shopping Cart:");
            double total = 0;
            for (CartItem item : items) {
                System.out.println(item.getProduct().getProductInfo() + " x" + item.getQuantity() + " = $" + String.format("%.2f", item.getTotalPrice()));
                total += item.getTotalPrice();
            }
            System.out.printf("Total: $%.2f\n", total);
        }
    }

