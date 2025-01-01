public class User {
    private String username;
    private String password;
    private String email;
    private String address;
    private String role;  // This will store the user's role: "admin" or "customer"

    public User(String username, String password, String email, String address, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.role = role; // Assign role
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
