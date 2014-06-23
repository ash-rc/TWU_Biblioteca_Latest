package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by thomasmorris on 6/18/14.
 */
public class Menu {

    private boolean shouldQuit = false;
    private Map<String, Command> methodMap;
    private PrintStream out;
    private Library library;
    private BufferedReader reader;

    public Menu(Map<String, Command> menuMap, PrintStream out, BufferedReader reader, Library library) {
        this.library = library;
        this.out = out;
        this.reader = reader;
        this.methodMap = menuMap;

    }

    public void displayMenu() {
        for (String option : methodMap.keySet()) {
            out.println(option);
        }
    }

    public void startTakingCommands() throws IOException {
     //   System.out.println("Welcome to biblioteca!");
        while (!shouldQuit()) {
            String input = reader.readLine();
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

    public void createCommands() {
        methodMap.put("List Books", new ListBooksCommand(library, System.out));
        methodMap.put("Checkout Book", new CheckOutCommand(reader,library, System.out));
    }

    public boolean shouldQuit(){
        return shouldQuit;
    }

    public void displayStartup() {
        out.println("Welcome to Biblioteca");
        displayMenu();
    }
}
