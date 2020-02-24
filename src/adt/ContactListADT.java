package adt;

import definition.Person;

public interface ContactListADT {
    void add(Person person);

    void viewContact();

    String searchContact(String firstName);

    Person remove(int index);
}
