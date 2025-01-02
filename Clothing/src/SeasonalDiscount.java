public class SeasonalDiscount extends Discount {
    public SeasonalDiscount(double discountPercentage) {
        super(discountPercentage);
    }

    @Override
    public void displayDiscountDetails() {
        System.out.println("Seasonal Discount: " + discountPercentage + "% off");
    }
}