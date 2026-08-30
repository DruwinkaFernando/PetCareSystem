package model;

import java.io.Serializable;

public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ownerId;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Owner(String ownerId, String name, String phone, String email, String address) {
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    p
