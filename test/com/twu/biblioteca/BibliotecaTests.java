package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class BibliotecaTests {
    private Library library;
    private Menu menu;
    private PrintStream mockStream;

    @Before
    public void setUp() {
        Hashtable<String, Command> decoyMap = new Hashtable<String, Command>();
        mockStream = mock(PrintStream.class);
        library = new Library(mockStream);
        menu = new Menu(decoyMap, mockStream);
    }

    @Test
    public void testWelcomeMessage() {

        menu.displayWelcomeMessage();
        verify(mockStream).println("Welcome to Biblioteca!");

    }


    @Test
    public void testQuit() throws Exception {
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("Quit");
        menu.startTakingCommands(reader);

    }

    @Test
    public void testListBooks() throws IOException {
        library.listBooks();
        verify(mockStream).printf("%-20s %-20s %-20s\n", "Head First Java", "Bill", "1924");
    }

    @Test
    public void testMenuListBooks() throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("List Books").thenReturn("Quit");

    }
    @Test
    public void testDisplayMenu(){
        menu.displayMenu();
        verify(mockStream).println("List Books");
    }

    @Test
    public void checkInvalidInput() throws IOException {

        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("Zoerir").thenReturn("Quit");
        menu.startTakingCommands(reader);
        verify(mockStream).println("Select a valid option!");

    }

}
