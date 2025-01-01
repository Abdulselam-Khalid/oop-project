public class Shipping {
    private String address;
    private String shippingMethod;
    private String trackingNumber;

    public Shipping(String address, String shippingMethod) {
        this.address = address;
        this.shippingMethod = shippingMethod;
        this.trackingNumber = generateTrackingNumber();
    }

    private String generateTrackingNumber() {
        return "TRACK" + (int) (Math.random() * 10000);
    }

    public String getShippingDetails() {
        return "Shipping to: " + address + ", Method: " + shippingMethod + ", Tracking #: " + trackingNumber;
}
}