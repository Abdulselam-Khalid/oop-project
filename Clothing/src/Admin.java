    public class Admin extends User {
    public Admin(String username, String password, String email, String address) {
        super(username, password, email, address, "admin");
    }

    public void addProduct(Product product) {
        // Logic for adding a product to inventory
    }

    public void removeProduct(Product product) {
        // Logic for removing a product
    }

    public void generateSalesReport() {
        // Logic for generating sales report
}
}

