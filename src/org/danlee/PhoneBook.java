package org.danlee;

import org.danlee.functionality.*;
import org.danlee.models.*;

public class PhoneBook extends InputOutput {
    private Person[] persons = {};
    private PhoneNumber[] phoneNumbers = {};
    private Address[] addresses = {};

    public PhoneBook() throws InterruptedException {
        while (!currentInput().equals("exit")) {
            printMainMenu();
            getInput();
            switch (currentInput()) {
                case "0" -> {
                    printAllContacts();
                }
                case "1" -> {
                    ContactModifer contactModifer = new ContactModifer(this);
                    contactModifer.addContact();
                }
                case "2" -> {
                    ContactFinder contactFinder = new ContactFinder(this);
                    contactFinder.findContact();
                }
            }
        }
    }

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public PhoneNumber[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumber[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }


    public void printAllContacts() throws InterruptedException {
        if (persons.length == 0) {
            loadAndPrint("No contacts");
            return;
        }
        StringBuilder all = new StringBuilder();

        for (Person person : persons) {
            all
                    .append(person.getFullName())
                    .append(" => with ")
                    .append(person.getPhoneNumbers().length)
                    .append(" numbers.")
                    .append("\n");
        }

        loadAndPrint(all.toString());
    }
}
