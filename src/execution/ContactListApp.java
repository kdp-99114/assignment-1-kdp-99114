package execution;

import java.util.Scanner;

public class ContactListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while (choice != 5) {
            System.out.println("Welcome to KDP's Contact List App\n" +
                    "Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program ");

            choice = sc.nextInt();
        }
    }
}
