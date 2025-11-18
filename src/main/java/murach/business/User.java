package murach.business;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String firstName;
    private String lastName;
    private String heardFrom;
    private String updates;
    private String contactVia;

    // Constructor không tham số
    public User() {}

    // Constructor có tham số
    public User(String email, String firstName, String lastName,
                String heardFrom, String updates, String contactVia) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heardFrom = heardFrom;
        this.updates = updates;
        this.contactVia = contactVia;
    }

    // Getter và Setter cho email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter và Setter cho firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter và Setter cho lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter và Setter cho heardFrom
    public String getHeardFrom() {
        return heardFrom;
    }

    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }

    // Getter và Setter cho updates
    public String getUpdates() {
        return updates;
    }

    public void setUpdates(String updates) {
        this.updates = updates;
    }

    // Getter và Setter cho contactVia
    public String getContactVia() {
        return contactVia;
    }

    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    }
}
