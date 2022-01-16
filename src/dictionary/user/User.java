package dictionary.admin;

import java.io.Serializable;

public class User implements Serializable {
private int id;
private String name;
private String pass;
private String phone_email;
private String address;

    public User() {
    }

    public User(int id, String name, String pass, String phone_email, String address) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.phone_email = phone_email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone_email() {
        return phone_email;
    }

    public void setPhone_email(String phone_email) {
        this.phone_email = phone_email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", phone_email='" + phone_email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
