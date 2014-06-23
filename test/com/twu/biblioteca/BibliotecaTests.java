package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class BibliotecaTests {
    private Library library;
    private PrintStream mockStream;
    private BufferedReader reader;
    private Menu menu;
    private List<Book> books;
    private Map<String, Command> decoyMap;

    @Before
    public void setUp() {
        mockStream = mock(PrintStream.class);
        books = new ArrayList <Book>();
        books.add(new Book("Head First Java", "Bill", "1924"));
        books.add(new Book("Game of Thrones", "J.R.R. Martin", "1992"));
        LengthFinder lengthFinder = mock(LengthFinder.class);
        library = new Library(mockStream, books, lengthFinder);
        reader = mock(BufferedReader.class);
        menu = new Menu(new HashMap<String, Command>(), mockStream, reader, library);
        menu.createCommands();
    }

    @Test
    public void testDisplayMenu(){
        menu.displayMenu();
        verify(mockStream).println("List Books");
    }

    @Test
    public void checkInvalidInput() throws IOException {
        when(reader.readLine()).thenReturn("Zoerir").thenReturn("Quit");
        menu.startTakingCommands();
        verify(mockStream).println("Select a valid option!");

    }

}
