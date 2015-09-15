package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {

    @Test
    public void shouldInitialiseWelcomeMessageAndDisplayIt() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));

        Controller controller = new Controller();
        controller.displayWelcomeMessage();

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldInitialiseMenuToDisplayItsOptionsAndDispatch() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        ByteArrayInputStream inputOption = new ByteArrayInputStream("Invalid".getBytes());
        System.setIn(inputOption);

        Controller controller = new Controller();
        controller.displayMenuOptionsAndDispatch();

        assertEquals("MAIN MENU\n1. List Books\n2. Checkout Book\n3. Return Book\n4. List Movies\n5. Quit\n\nSelect " +
                "a valid option!\n", outputContent.toString());
    }
}