  public abstract class Discount {
    protected double discountPercentage;

    public Discount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double applyDiscount(double price) {
        return price - (price * (discountPercentage / 100));
    }

    public abstract void displayDiscountDetails();
}

