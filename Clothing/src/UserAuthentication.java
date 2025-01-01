public class UserAuthentication {
    public User authenticateUser(String username, String password) {
        // Logic to authenticate user (simplified example)
        // Example: Assume we have some hardcoded users for now

        if (username.equals("admin") && password.equals("admin123")) {
            return new User(username, password, "admin@example.com", "Admin Address", "admin");
        } else if (username.equals("c") && password.equals("1")) {
            return new User(username, password, "customer@example.com", "Customer Address", "customer");
        } else {
            return null; // Invalid credentials
        }
    }

    public void registerUser(String username, String password, String email, String address, String role) {
        // Logic to register a new user
        // For simplicity, we can just create a new user here
    }
}
