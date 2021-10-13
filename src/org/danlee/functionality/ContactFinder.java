package org.danlee.functionality;

import org.danlee.PhoneBook;
import org.danlee.models.Person;

import java.util.Arrays;

public class ContactFinder {
    private final PhoneBook phoneBook;

    public ContactFinder(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void findContact() throws InterruptedException {

        printContactFinderMenu();

        phoneBook.getInput();

        switch (phoneBook.currentInput()) {
            case "1" -> {
                System.out.println("Enter last name");
                String lastName = phoneBook.getInput();

                Person[] contacts = filterPersonsByCase("1", lastName);
                printOutContacts(contacts);
            }
            case "2" -> {
                System.out.println("Enter first name");
                String firstName = phoneBook.getInput();

                Person[] contacts = filterPersonsByCase("1", firstName);
                printOutContacts(contacts);
            }
            case "3" -> {}
        }
    }

    private void printContactFinderMenu() {
        System.out.println("How do you want to find your contact?");
        System.out.println("1 by last name");
        System.out.println("2 by first name");
        System.out.println("3 by full name (first last)");
        System.out.println("4 by phone number");
    }

    private void printOutContacts(Person[] contacts) throws InterruptedException {
        StringBuilder output = new StringBuilder();

        output.append("Found ").append(contacts.length).append(" contact(s) with your search parameters.\n");

        for (Person contact : contacts) {
            output
                    .append(contact.getFullName())
                    .append("\n")
                    .append(contact.getAddressString())
                    .append("\nPhone Numbers:\n")
                    .append(contact.getAllNumbersAsString())
                    .append("\n");
        }

        phoneBook.loadAndPrint(output.toString());
    }

    private Person[] filterPersonsByCase(String caseInput, String comparison) {
        Person[] contacts = {};
        for (Person person : phoneBook.getPersons()) {
            switch (caseInput) {
                case "1": if (person.getLastName().equals(comparison)) contacts = addToContactsArray(contacts, person);
                case "2": if (person.getFirstName().equals(comparison)) contacts = addToContactsArray(contacts, person);
            }
        }

        return contacts;
    }


    private Person[] addToContactsArray(Person[] contacts, Person person) {
        contacts = Arrays.copyOf(contacts, contacts.length + 1);
        contacts[contacts.length - 1] = person;
        return contacts;
    }
}
