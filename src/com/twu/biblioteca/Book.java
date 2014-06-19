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
}
