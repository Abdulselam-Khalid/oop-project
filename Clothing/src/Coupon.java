import java.util.Date;

public class Coupon {
    private String code;
    private Date expirationDate;
    private double discountValue;

    public Coupon(String code, Date expirationDate, double discountValue) {
        this.code = code;
        this.expirationDate = expirationDate;
        this.discountValue = discountValue;
    }

    public boolean isValid() {
        return expirationDate.after(new Date());
    }

    public double applyCoupon(double totalAmount) {
        if (isValid()) {
            return totalAmount - (totalAmount * discountValue / 100);
        }
        return totalAmount;
}
}