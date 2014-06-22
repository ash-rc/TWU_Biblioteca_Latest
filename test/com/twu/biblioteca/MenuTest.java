package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ashleycampo on 6/20/14.
 */
public class MenuTest {
    private Library library;
    private PrintStream mockStream;
    private BufferedReader reader;
    private Menu menu;

    @Before
    public void setUp() {
        Hashtable<String, Command> decoyMap = new Hashtable<String, Command>();
        mockStream = mock(PrintStream.class);
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        menu = new Menu(decoyMap, mockStream, reader);
    }

    @Test
    public void testWelcomeMessage() throws IOException {
        menu.startTakingCommands();
        when(reader.readLine()).thenReturn("Quit");
        verify(mockStream).println("Welcome to Biblioteca!");

    }

    @Test
    public void testQuit() throws Exception {
        when(reader.readLine()).thenReturn("Quit");
        menu.startTakingCommands();
    }
}
