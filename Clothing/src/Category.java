import java.util.ArrayList;
import java.util.List;

    public class Category {
        private String name;
        private List<Product> products;

        public Category(String name) {
            this.name = name;
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public void removeProduct(Product product) {
            products.remove(product);
        }

        public List<Product> getProducts() {
            return products;
        }

        public String getName() {
            return name;

        }
    }