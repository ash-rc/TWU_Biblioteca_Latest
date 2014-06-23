package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Library {

    private List<Book> availableBooks;
    private List<Book> unavailableBooks;
    private PrintStream out;
    private LengthFinder lengthFinder;

    public Library(PrintStream out, List<Book> availableBooks, List<Book> unavailableBooks, LengthFinder lengthFinder) {
        this.out = out;
        this.availableBooks = availableBooks;
        this.unavailableBooks = unavailableBooks;
        this.lengthFinder = lengthFinder;
    }

    public void checkoutBook(String bookTitle){
        Book book = findBook(bookTitle, availableBooks);
        if(book != null){
            unavailableBooks.add(book);
            availableBooks.remove(book);
            out.println("Thank you! Enjoy " + book.getTitle());
        } else {
            out.println("Book not available.");
        }
    }

    public Book findBook(String title, List<Book> books) {
        for(Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        int descriptorOffset = getLongestDescriptor() + 5;
        String printFormat = "%-" + descriptorOffset + "s %-" + descriptorOffset + "s %-4s\n";
        for(Book book : availableBooks) {
            out.printf(printFormat, book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    private int getLongestDescriptor(){
        return lengthFinder.findLongestString(getDescriptorList());
    }

    private List<String> getDescriptorList() {
        List<String> descriptorList = new ArrayList<String>();
        for(Book book : availableBooks) {
            descriptorList.add(book.getAuthor());
            descriptorList.add(book.getTitle());
        }
        return descriptorList;
    }

    public void returnBook(String title) {
        Book book = findBook(title, unavailableBooks);
        if(book != null){
            availableBooks.add(book);
            unavailableBooks.remove(book);
            out.println("Thank you for returning " + book.getTitle());
        } else {
            out.println("This is not a valid book return.");
        }
    }
}
