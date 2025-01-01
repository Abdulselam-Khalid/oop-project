    public class Order {
        private static int orderCounter = 0;
        private int orderId;
        private User user;
        private ShoppingCart cart;
        private String shippingAddress;
        private boolean paymentStatus;

        public Order(User user, ShoppingCartManager cart, String shippingAddress) {
            this.orderId = ++orderCounter;
            this.user = user;
            this.cart = cart;
            this.shippingAddress = shippingAddress;
            this.paymentStatus = false;  // Initially unpaid
        }

        public void processOrder() {
            // Process payment
            this.paymentStatus = true;
            // Update product stock, etc.
            for (CartItem item : cart.getItems()) {
                item.getProduct().updateStock(item.getQuantity());
            }
        }

        public int getOrderId() {
            return orderId;
        }

        public boolean getPaymentStatus() {
            return paymentStatus;
        }


        public User getUser() {
            return user;
        }

    }