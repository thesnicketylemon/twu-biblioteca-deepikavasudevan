package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {
    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Test
    public void shouldDisplayAWelcomeMessage() {
            System.setOut(new PrintStream(outputContent));
            WelcomeMessage welcomeMessage = new WelcomeMessage();

            welcomeMessage.display();

            assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
        }
    }

