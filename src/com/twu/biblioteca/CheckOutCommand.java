package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by thomasmorris on 6/20/14.
 */
public class CheckOutCommand implements Command {

    private Library library;
    private PrintStream out;
    private BufferedReader reader;

    public CheckOutCommand(BufferedReader r, Library l, PrintStream out){
        this.library = l;
        this.reader = r;
        this.out = out;
    }
    @Override
    public void execute() throws IOException {

        library.checkoutBook(reader.readLine());
    }
}
