package adt;

import definition.Person;

public interface ContactListADT {
    void add(Person person);

    void viewContact();

    int searchContact(String firstName);
}
