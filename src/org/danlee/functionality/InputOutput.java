package org.danlee.functionality;

import java.util.Scanner;

public class InputOutput {
    private Scanner in = new Scanner(System.in);
    private String input = "";

    public void printMainMenu() {
        System.out.println("========= MENU ===========");
        System.out.println("Type 'exit' without quotes to cancel the program at anytime");
        System.out.println("Menu: ");
        System.out.println("0 print all contacts");
        System.out.println("1 to add new contact");
        System.out.println("2 to find a contact");
        System.out.println("3 to delete contact");
        System.out.println("Type 'exit' without quotes to cancel the program at anytime");
        System.out.println("========= MENU END ===========");
    }

    public String getInput() {
        this.input = in.next();
        if (input.equals("exit")) {
            System.exit(0);
        }

        return input;
    }

    public String currentInput() {
        return input;
    }

    public void loadAndPrint(String message) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println("loading...");
            Thread.sleep(350);
        }
        System.out.println(message);

        Thread.sleep(2000);
    }
}
