public class UserProfile {
    private String username;
    private String email;
    private String address;

    public UserProfile(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public void updateProfile(String address, String email) {
        this.address = address;
        this.email = email;
    }

    public String getProfileInfo() {
        return "Username: " + username + ", Email: " + email + ", Address: " + address;
}
}