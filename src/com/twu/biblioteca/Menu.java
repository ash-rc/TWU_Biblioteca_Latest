package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

/**
 * Created by thomasmorris on 6/18/14.
 */
public class Menu {

    private boolean shouldQuit = false;
    private Hashtable<String, Command> methodMap;// = new Hashtable<String, Command>();
    private PrintStream out;
    private Library library;

    public Menu(Hashtable<String, Command> menuMap, PrintStream out){

        this.out = out;

        library = new Library(this.out);

        this.methodMap = menuMap;
        methodMap.put("List Books", new ListBooksCommand(library, this.out));


    }

    public void displayMenu() {
        for (String option : methodMap.keySet()) {
            out.println(option);
        }
    }

    public void startTakingCommands(BufferedReader reader) throws IOException {
        String input;


        while (!shouldQuit()) {
            input = reader.readLine();
            if (input.equals("Quit")){
                shouldQuit = true;

            } else if (methodMap.containsKey(input)) {
                methodMap.get(input).execute();
            }
            else {
                out.println("Select a valid option!");
            }
        }
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to Biblioteca!");
    }

    public boolean shouldQuit(){
        return shouldQuit;
    }
}
