package definition;

import adt.ContactListADT;

public class ContactList implements ContactListADT {

    private Node head = null;
    private int size = 0;

    private Node getNode(int index) {
        Node response = head;

        for (int i = 0; i < index; i++) {
            response = response.getNext();
        }
        return response;
    }

    private void addFirst(Person person) {
        head = new Node(person, head);
        size++;
    }

    private void addAfter(Node node, Person person) {
        node.next = new Node(person, node.next);
        size++;
    }

    public void add(int index, Person person) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            addFirst(person);
        } else {
            Node temp = getNode(index - 1);
            addAfter(temp, person);
        }
    }

    @Override
    public void add(Person person) {
        add(size, person);
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

        public Person getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

}
