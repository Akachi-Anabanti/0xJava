package shopper.src.main.java.models;

import java.util.UUID;

import shopper.src.main.java.BaseClass;
import shopper.src.main.java.stores.UserStore;

public class User extends BaseClass {
    private String firstName;
    private String lastName;
    private String hashedPassword;
    private String email;

    public User(String email, String password) {
        super();
        this.email = email;
        setHashedPassword(password);
    }


    public void setHashedPassword(String password) {
        this.hashedPassword = hashPassword(password);
    }

    private String hashPassword(String password) {
        StringBuilder passwordBuilder = new StringBuilder(password);
        return passwordBuilder.reverse().toString() + "%" + UUID.randomUUID().toString();
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    // firstName getter and setter
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        update();
    }

    // lastName getter and setter
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
        update();
    }

    // email setter and getter
    public void setEmail(String email) {
        this.email = email;
        update();
    }
    public String getEmail() {
        return email;
    }

    public void save() {
        UserStore.getInstance().saveUser(this);
    }
}