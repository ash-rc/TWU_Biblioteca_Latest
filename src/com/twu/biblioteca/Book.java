package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Book {
    String author;
    String year;
    String title;

    public Book(String t, String a, String y) {
        author = a;
        year = y;
        title = t;
    }

    public String toString() {
        return (title + "\t" + author + "\t" + year);
    }

    public void print(PrintStream out) {
        out.printf("%-20s %-20s %-20s\n", title, author, year);
    }

    @Override
    public boolean equals(Object _book) {
        Book book = (Book) _book;

        return author.equals(book.getAuthor()) && title.equals(book.getTitle()) && year.equals(book.getYear());


    }

    public String getTitle(){
        return title;
    }

    public String getYear(){
        return year;
    }

    public String getAuthor() {
        return author;
    }
}
