
public class Coupon {
    private String code;
    private double discountValue;

    public Coupon(String code, double discountValue) {
        this.code = code;
        this.discountValue = discountValue;
    }

    public boolean isValid() {
        if(code.equals("A10")){
            return true;
        }
        else
        return false;
    }

    public double applyCoupon(double totalAmount) {
        if (isValid()) {
            return totalAmount - (totalAmount * discountValue / 100);
        }
        return totalAmount;
}
}