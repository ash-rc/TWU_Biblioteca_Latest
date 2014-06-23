package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by thomasmorris on 6/20/14.
 */
public class CheckOutCommand implements Command {
    private Library library;
    private BufferedReader reader;

    public CheckOutCommand(BufferedReader reader, Library library){
        this.library = library;
        this.reader = reader;
    }
    @Override
    public void execute() throws IOException {
        library.checkoutBook(reader.readLine());
    }
}
