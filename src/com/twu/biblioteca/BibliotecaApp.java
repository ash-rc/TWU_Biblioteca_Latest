package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class BibliotecaApp {
    //Commit works
    public static void main(String[] args) throws IOException {

          Menu menu = new Menu(new Hashtable<String, Command>(), System.out);
          menu.displayMenu();
          menu.startTakingCommands(new BufferedReader(new InputStreamReader(System.in)));
    }
}
