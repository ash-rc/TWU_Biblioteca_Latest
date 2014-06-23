package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Library {

    private List<Book> books;
    private PrintStream out;
    private LengthFinder lengthFinder;

    public Library(PrintStream out, List<Book> books, LengthFinder lengthFinder) {
        this.out = out;
        this.books = books;
        this.lengthFinder = lengthFinder;
    }

    public void checkoutBook(String bookTitle) throws IOException {
        Book book = findBook(bookTitle);
        if(book != null){
            books.remove(book);
            out.println("Thank you! Enjoy " + book.getTitle());
        } else {
            out.println("Book not available.");
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
        int descriptorOffset = getLongestDescriptor() + 5;
        String printFormat = "%-" + descriptorOffset + "s %-" + descriptorOffset + "s %-4s\n";
        for(Book book : books) {
            out.printf(printFormat, book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    private int getLongestDescriptor(){
        return lengthFinder.findLongestString(getDescriptorList());
    }

    private List<String> getDescriptorList() {
        List<String> descriptorList = new ArrayList<String>();
        for(Book book : books) {
            descriptorList.add(book.getAuthor());
            descriptorList.add(book.getTitle());
        }
        return descriptorList;
    }
}
