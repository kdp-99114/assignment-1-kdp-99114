package execution;

import definition.ContactList;
import definition.Person;
import helper.ContactListHelper;

import java.util.Scanner;

public class ContactListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactList contactList = new ContactList();
        ContactListHelper contactListHelper = new ContactListHelper();

        int choice = 0;
        while (choice != 5) {
            System.out.println("Welcome to KDP's Contact List App\n" +
                    "Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You have chosen to add a new contact:");
                    Person person = contactListHelper.addContactMenu();
                    contactList.add(person);
                    contactList.sort();
                    break;
                case 2:
                    System.out.println("---Here are all your contacts---");
                    contactListHelper.viewContactMenu(contactList);
                    break;
                case 3:
                    System.out.println("You could search for a contact from their first names: ");
                    contactListHelper.searchContactMenu(contactList);
                    break;
            }
        }
    }
}
