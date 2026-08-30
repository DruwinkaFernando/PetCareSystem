package model;

import java.io.Serializable;
import java.util.List;

// Abstract base class - cannot be instantiated directly.
// Demonstrates ABSTRACTION + ENCAPSULATION (private fields, public getters).
public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;
    private String password;
    private String fullName;

    public User(String userId, String username, String password, String fullName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public void setPassword(String password) { this.password = password; }

    // Abstract methods - every subclass MUST implement these differently.
    // This is what creates POLYMORPHISM: calling getRole() on a User
    // reference gives a different answer depending on the real object type.
    public abstract String getRole();
    public abstract List<String> getAccessibleModules();
}
