package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ashleycampo on 6/20/14.
 */
public class LibraryTest {
    private Library library;
    private PrintStream mockStream;
    private List<Book> books;
    private LengthFinder lengthFinder;

    @Before
    public void setUp() {
        mockStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        lengthFinder = new LengthFinder();
        books.add(new Book("Head First Java", "Bill", "1924"));
        books.add(new Book("A Song of Ice and Fire", "J.R.R. Martin", "1992"));
        library = new Library(mockStream, books, lengthFinder);
    }


    @Test
    public void testListBooks() throws IOException {
        int descriptorOffset = "A Song of Ice And Fire".length() + 5;
        String printFormat = "%-" + descriptorOffset + "s %-" + descriptorOffset + "s %-4s\n";
        library.listBooks();
        verify(mockStream).printf(printFormat, "Head First Java", "Bill", "1924");
        verify(mockStream).printf(printFormat, "A Song of Ice and Fire", "J.R.R. Martin", "1992");
    }

    @Test
    public void checkOutBook() throws IOException {
        Book book = new Book("Head First Java", "Bill", "1924");
        library.checkoutBook(book.getTitle());
        assertThat(books.contains(book), is(false));
    }

    @Test
    public void whenCheckoutSuccessfulReturnMessage() throws IOException {
        Book book = new Book("Head First Java", "Bill", "1924");
        library.checkoutBook(book.getTitle());
        verify(mockStream).println("Thank you! Enjoy Head First Java");
    }
}
