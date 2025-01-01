public class Inventory {
    private ProductManager productManager;

    public Inventory(ProductManager productManager) {
        this.productManager = productManager;
    }

    public boolean isProductAvailable(Product product, int quantity) {
        return product.getPrice() > 0 && quantity <= product.getStockQuantity();
    }

    public void updateProductStock(Product product, int quantity) {
        product.updateStock(quantity);
}
}
