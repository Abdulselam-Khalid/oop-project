import java.util.HashMap;
import java.util.Map;

public class DiscountManager {
    private Map<String, Discount> discounts;

    public DiscountManager() {
        discounts = new HashMap<>();
    }

    public void addDiscount(String code, Discount discount) {
        discounts.put(code, discount);
    }
    // Initialize default discounts in DiscountManager
    public void initializeDefaultDiscounts() {
        // Example discounts
        addDiscount("BLACKFRIDAY", new SeasonalDiscount(50)); // 50% off for Black Friday
        addDiscount("SEASONAL10", new SeasonalDiscount(10)); // 10% off seasonal
        addDiscount("BULKBUY", new BulkDiscount(20, 5)); // 20% off for bulk purchases of 5 or more
    }

    public Discount getDiscount(String code) {
        return discounts.get(code);
    }

    public boolean applyDiscount(String code, Product product) {
        Discount discount = discounts.get(code);
        if (discount != null) {
            double discountedPrice = discount.applyDiscount(product.getPrice());
            product.updatePrice(discountedPrice);
            return true;
        }
        return false;
}
}
