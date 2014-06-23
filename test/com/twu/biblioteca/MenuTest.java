package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

/**
 * Created by ashleycampo on 6/20/14.
 */
public class MenuTest {
    private Library library;
    private PrintStream mockStream;
    private BufferedReader reader;
    private Menu menu;
    private Map<String, Command> methodMap;

    @Before
    public void setUp() {
        methodMap = new Hashtable<String, Command>();
        mockStream = mock(PrintStream.class);
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        menu = new Menu(methodMap, mockStream, reader, library);
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

    @Test
    public void shouldCreateCommands() {
        menu.createCommands();
        boolean hasListBooks = methodMap.keySet().contains("List Books");
        boolean hasCheckoutBook = methodMap.keySet().contains("Checkout Book");
        boolean hasReturnBook = methodMap.keySet().contains("Return Book");
        assertThat(hasListBooks, is(true));
        assertThat(hasCheckoutBook, is(true));
        assertThat(hasReturnBook, is(true));
    }
}
