package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

import static org.mockito.Mockito.*;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class BibliotecaTests {
    private Library library;
    private PrintStream mockStream;
    private BufferedReader reader;
    private Menu menu;

    @Before
    public void setUp() {
        Hashtable<String, Command> decoyMap = new Hashtable<String, Command>();
        mockStream = mock(PrintStream.class);
        library = new Library(mockStream, books);
        reader = mock(BufferedReader.class);
        menu = new Menu(decoyMap, mockStream, reader);
    }






    @Test
    public void testMenuListBooks() throws IOException {
        menu.startTakingCommands();
        when(reader.readLine()).thenReturn("List Books").thenReturn("Quit");

        verify(mockStream).printf("%-20s %-20s %-20s\n", "Game of Thrones", "J.R.R. Martin", "1992");
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

    @Test
    public void checkOutBook() throws IOException {
        String book = "Head First Java";

        library.checkoutBook(reader);
        when(reader.readLine()).thenReturn(book);
        library.listBooks();
        verify(mockStream).printf("%-20s %-20s %-20s\n", "Game of Thrones", "J.R.R. Martin", "1992");

    }

}
