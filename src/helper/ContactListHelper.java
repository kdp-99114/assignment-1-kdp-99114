package helper;

import definition.ContactList;
import definition.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactListHelper {

    Scanner sc = new Scanner(System.in);
    Person person;

    public Person addContactMenu() {
        sc.nextLine();
        ArrayList<Long> contactNumber = new ArrayList<>();
        String email = "";
        System.out.println("Please enter the name of the Person");
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        char choiceContact = 'y';
        while (choiceContact != 'n') {
            System.out.print("Contact Number: ");
            contactNumber.add(sc.nextLong());
            System.out.print("Would you like to add another contact number? (y/n): ");
            choiceContact = sc.next().charAt(0);
        }
        System.out.print("Would you like to add email address? (y/n): ");
        char choiceEmail = sc.next().charAt(0);
        if (choiceEmail == 'y') {
            System.out.println("Email Address: ");
            email = sc.nextLine();
        }
        return new Person(firstName, lastName, contactNumber, email);
    }

    public void viewContactMenu(ContactList contactList) {
        for (int i = 0; i < contactList.getSize(); i++) {
            System.out.println("-------- * -------- * -------- * --------");
            contactList.viewContact(i);
            System.out.println("-------- * -------- * -------- * --------");
        }
    }

    public void searchContactMenu(ContactList contactList) {
        String firstName = sc.nextLine();
        String index = contactList.searchContact(firstName);
        String[] indexValues = new String[index.length()];
        int individualIndex;
        if (!index.equals("")) {
            for (int i = 0; i < index.length(); i++) {
                indexValues[i] = index.substring(i, i + 1);
            }
            for (String indexValue : indexValues) {
                individualIndex = Integer.parseInt(indexValue);
                System.out.println("-------- * -------- * -------- * --------");
                contactList.viewContact(individualIndex);
                System.out.println("-------- * -------- * -------- * --------");
            }
        }

    }
}

