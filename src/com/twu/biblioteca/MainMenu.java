/*Main Menu shows list of options from which one is chosen by user*/
package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {

    private ArrayList<String> menuOptions = new ArrayList<String>();

    MainMenu(ArrayList<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void display() {
        System.out.println("MAIN MENU");

        for (String menuOption : menuOptions) {
            System.out.println(menuOption);
        }
    }

    public void dispatch(Library library, String option) {
        if (option.equals("1")) {
            library.listBooks();
        } else if (option.equals("2")) {
            System.out.println("Thank you! Enjoy the book");
        } else if (option.equals("Quit"))
            System.exit(0);
        else
            System.out.println("Select a valid option!");
    }
}