package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {
    public static void main(String[] args) throws IOException {
        initializeBiblioteca();
    }

    public static void initializeBiblioteca() throws IOException {

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Bill", "1924"));
        books.add(new Book("Game of Thrones", "J.R.R. Martin", "1992"));
        LengthFinder lengthFinder = new LengthFinder();
        Library library = new Library(System.out, books, lengthFinder);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Command> methodMap = new HashMap<String, Command>();
        Menu menu = new Menu(methodMap, System.out, reader, library);

        menu.createCommands();
        menu.displayStartup();
        menu.startTakingCommands();
    }
}
