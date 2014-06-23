package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by ashleycampo on 6/23/14.
 */
public class ReturnBookCommand implements Command {
    private BufferedReader reader;
    private Library library;

    public ReturnBookCommand(BufferedReader reader, Library library) {
        this.reader = reader;
        this.library = library;
    }

    @Override
    public void execute() throws IOException {
        String book = reader.readLine();
        library.returnBook(book);
    }
}
