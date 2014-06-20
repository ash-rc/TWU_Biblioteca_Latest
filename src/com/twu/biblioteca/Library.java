package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Library {

    private List<Book> books;
    private PrintStream out;

    public Library(PrintStream out, List<Book> books) {
        this.out = out;
        this.books = books;
    }

    public void checkoutBook(BufferedReader reader) throws IOException {
        Book book = findBook(reader.readLine());
        if(book != null){
            books.remove(book);
        } else {
            System.out.println("Book not available.");
        }
    }

    public Book findBook(String title) {
        for(Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        for(Book b : books) {
            b.print(out);
        }
    }

}
