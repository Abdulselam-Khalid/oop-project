import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
        Product product1 = new Product("T-Shirt", 19.99, "Medium", "Blue", 30);
        Product product2 = new Product("Jeans", 49.99, "Large", "Black", 20);
        Product product3 = new Product("Jacket", 79.99, "Small", "Red", 15);
        Product product4 = new Product("Sneakers", 99.99, "Size 10", "White", 25);
        Product product5 = new Product("Hat", 15.99, "One Size", "Green", 50);
        addProduct(product1);
        addProduct(product2);
        addProduct(product3);
        addProduct(product4);
        addProduct(product5);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public Product searchProductByName(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null; // Not found
    }

    public List<Product> getAllProducts() {
        return productList;
}
}
