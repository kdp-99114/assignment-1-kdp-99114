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
        private Person data;
        private Node next;

        public Node(Person data) {
            this.data = data;
        }

        public Node(Person data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
