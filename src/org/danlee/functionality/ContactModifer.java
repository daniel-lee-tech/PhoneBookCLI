package org.danlee.functionality;

import org.danlee.PhoneBook;
import org.danlee.models.Person;

import java.util.Arrays;

public class ContactModifer {
    private final PhoneBook phoneBook;

    public ContactModifer(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addContact() throws InterruptedException {
        Person[] persons = phoneBook.getPersons();
        System.out.println("Enter first name: ");
        String firstName = phoneBook.getInput();

        System.out.println("Enter last name: ");
        String lastName = phoneBook.getInput();

        Person newPerson = new Person(firstName, lastName);

        persons = Arrays.copyOf(persons, persons.length + 1);
        persons[persons.length - 1] = newPerson;

        phoneBook.loadAndPrint(firstName + " " + lastName + " has been added.");
    }
}
