package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by michaelhassin on 6/18/14.
 */
public class ListBooksCommand implements  Command{

    private Library library;
    private PrintStream out;

    public ListBooksCommand(Library l, PrintStream out){
        this.library = l;
        this.out = out;
    }

    @Override
    public void execute() {
        library.listBooks();
    }
}
