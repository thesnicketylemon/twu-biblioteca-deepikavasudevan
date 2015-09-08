package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;


public class BibliotecaApplicationTest {

    private ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inputContent = new ByteArrayInputStream("Quit".getBytes());

    @Test
    public void shouldPrintWelcomeMessage() {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();

        bibliotecaApplication.displayWelcomeMessage("Hello! Welcome to Bangalore Public Library");

        assertEquals("Hello! Welcome to Bangalore Public Library!\n", outputContent.toString());
    }
}