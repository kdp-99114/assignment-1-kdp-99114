package definition;

import adt.ContactListADT;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList implements ContactListADT {

    private Node head = null;
    private int size = 0;

    Scanner sc = new Scanner(System.in);

    private Node getNode(int index) {
        Node response = head;

        for (int i = 0; i < index; i++) {
            response = response.getNext();
        }
        return response;
    }

    public int getSize() {
        return size;
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

    private String getContactNumber(ArrayList<Long> contactNumber) {
        String conNum = "";
        for (int i = 0; i < contactNumber.size(); i++) {
            conNum = conNum + contactNumber.get(i) + (i < contactNumber.size() - 1 ? ", " : "");
        }
        return conNum;
    }

    public void viewContact(int index) {
        Person person = this.getNode(index).getData();
        System.out.println("First Name: " + person.getFirstName() + '\n' +
                "Last Name: " + person.getLastName() + '\n' +
                (person.getContactNumber().size() > 1 ? "Contact Number(s): " : "Contact Number: ") + this.getContactNumber(person.getContactNumber()) + '\n' +
                "Email address: " + person.getEmail());
    }

    @Override
    public void viewContact() {
        for (int i = 0; i < size; i++) {
            viewContact(i);
            System.out.println();
        }
    }

    @Override
    public String searchContact(String firstName) {
        String response = "";
        for (int i = 0; i < size; i++) {
            Person person = this.getNode(i).getData();
            if (firstName.equals(person.getFirstName())) {
                response = response + i;
            }
        }
        return response;
    }

    private Person removeFirst() {
        Person response = null;
        Node temp = head;
        if (head != null) {
            head = head.getNext();
        }
        if (temp != null) {
            size--;
            response = temp.getData();
        }
        return response;
    }

    private Person removeAfter(Node node) {
        Person response = null;
        Node temp = node.getNext();
        if (temp != null) {
            node.next = temp.getNext();
            size--;
            response = temp.getData();
        }
        return response;
    }

    public Person remove(int index) {
        Person response = null;
        // check for valid index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) { /* check if the index is zero*/
            response = removeFirst();
        } else {
            Node previousNode = getNode(index - 1);
            response = removeAfter(previousNode);
        }
        return response;
    }

    @Override
    public Person remove() {
        return remove(size - 1);
    }

    private void swap(Node firstNode, Node secondNode) {
        Node temp = firstNode;
        firstNode = secondNode;
        secondNode = temp;
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - 1) - i; j++) {
                Node firstNode = this.getNode(j);
                Node secondNode = this.getNode(j + 1);
                int compare = (firstNode.getData().getFirstName()).compareTo(secondNode.getData().getFirstName());
                if (compare > 0) {
                    swap(firstNode, secondNode);
                }
            }
        }
    }

    public Person deleteContactMenu() {
        System.out.println("Here are all your contacts: ");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "." + this.getNode(i).getData().getFirstName() + " " + this.getNode(i).getData().getLastName());
        }
        System.out.print("Press the number against the contact to delete it: ");
        int index = sc.nextInt();
        Person person = this.remove(index - 1);
        return person;
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
