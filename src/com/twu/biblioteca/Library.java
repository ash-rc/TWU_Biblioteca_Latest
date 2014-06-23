package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Library {

    private LibraryItemCollections books;
    private LibraryItemCollections movies;
    private PrintStream out;
    private LengthFinder lengthFinder;

    public Library(LibraryItemCollections books, LibraryItemCollections movies) {
        this.books = books;
        this.movies = movies;
    }

}
