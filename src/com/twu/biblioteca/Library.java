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
        int titleOffset = getLongestTitle(books) + 5;
        int authorOffset = getLongestAuthor(books) + 5;
        String printFormat = "%-" + titleOffset + "s %-" + authorOffset + "s %-4s\n";
        for(Book book : books) {
            out.printf(printFormat, book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    private int getLongestTitle(List<Book> books) {
        int longestTitleLength = 0;

        for(Book book : books) {
            if(book.getTitle().length() > longestTitleLength) {
                longestTitleLength = book.getTitle().length();
            }
        }
        return longestTitleLength;
    }

    private int getLongestAuthor(List<Book> books) {
        int longestAuthorLength = 0;

        for(Book book : books) {
            if(book.getAuthor().length() > longestAuthorLength) {
                longestAuthorLength= book.getAuthor().length();
            }
        }
        return longestAuthorLength;
    }
}
