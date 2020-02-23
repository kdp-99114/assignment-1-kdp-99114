package definition;

import adt.ContactListADT;

public class ContactList implements ContactListADT {
    @Override
    public void add(Person person) {

    }

    @Override
    public void viewContact() {

    }

    @Override
    public int searchContact(String firstName) {
        return 0;
    }

    @Override
    public Person remove(int index) {
        return null;
    }

    private static class Node {
    }

}
