package definition;

import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<Long> contactNumber;
    private String email;

    public Person(String firstName, String lastName, ArrayList<Long> contactNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Long> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList<Long> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
