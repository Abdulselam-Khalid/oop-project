public class Product {
    private String name;
    private double price;
    private String size;
    private String color;
    private int stockQuantity;

    public Product(String name, double price, String size, String color, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.stockQuantity = stockQuantity;
    }

    public void updateStock(int quantity) {
        if (quantity > stockQuantity) {
            System.out.println("Not enough stock!");
        } else {
            this.stockQuantity -= quantity;
        }
    }
    public void removedStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public String getProductInfo() {
        return name + " (" + size + ", " + color + ") - $" + price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public String getName() {
        return name;
    }


    public void updatePrice(double discountedPrice) {
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}