public class BulkDiscount extends Discount {
    private int minQuantity;

    public BulkDiscount(double discountPercentage, int minQuantity) {
        super(discountPercentage);
        this.minQuantity = minQuantity;
    }

    @Override
    public void displayDiscountDetails() {
        System.out.println("Bulk Discount: " + discountPercentage + "% off when buying " + minQuantity + " or more.");
    }
}