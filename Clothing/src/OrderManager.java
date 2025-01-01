import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        order.processOrder(); // Process the order, e.g., deduct stock, process payment
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null; // Not found
    }

    public List<Order> getAllOrders() {
        return orders;
}
}