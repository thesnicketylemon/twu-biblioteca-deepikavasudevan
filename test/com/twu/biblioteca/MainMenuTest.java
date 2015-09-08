package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inputOptionOne = new ByteArrayInputStream("1".getBytes());
    private ByteArrayInputStream inputInvalid = new ByteArrayInputStream("Invalid".getBytes());
    private ByteArrayInputStream inputQuit = new ByteArrayInputStream("Quit".getBytes());

    @Before
    public void setStreamsWithInitialValue() {
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldDisplayListOfOptionsInMainMenu() {
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books", "Quit"));
        MainMenu mainMenu = new MainMenu(menuOptions);

        mainMenu.display();

        assertEquals("MAIN MENU\n1. List Books\nQuit\n", outputContent.toString());
    }

    @Test
    public void shouldListBooksWhenOptionIsInputtedAsOne() {
        System.setIn(inputOptionOne);
        Library library = new Library();
        ConsoleInput consoleInput = new ConsoleInput();
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        MainMenu mainMenu = new MainMenu(menuOptions);

        mainMenu.dispatch(library, consoleInput.getInput());

        assertEquals("NAME OF BOOK\tNAME OF AUTHOR\tYEAR OF PUBLICATION\nTo Kill A Mockingbird\tHarper Lee\t1968\nGone Girl\tGillian Flynn\t2000\n", outputContent.toString());
    }

    @Test
    public void shouldGiveAppropriateMessageWhenInvalidOptionIsEntered() {
        System.setIn(inputInvalid);
        Library library = new Library();
        ArrayList<String> menuOptions = new ArrayList<>(Arrays.asList("1. List Books"));
        MainMenu mainMenu = new MainMenu(menuOptions);
        ConsoleInput consoleInput = new ConsoleInput();

        mainMenu.dispatch(library, consoleInput.getInput());

        assertEquals("Select a valid option!\n", outputContent.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitTheApplicationWhenQuitOptionIsEnabled() {
        System.setIn(inputQuit);

        exit.expectSystemExit();
        System.exit(0);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setIn(System.in);
    }
}