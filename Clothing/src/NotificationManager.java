public class NotificationManager {
    public void sendOrderConfirmation(User user) {
        System.out.println("Sending order confirmation to " + user.getEmail());
    }

    public void sendShippingUpdate(User user) {
        System.out.println("Sending shipping update to " + user.getEmail());
}
}