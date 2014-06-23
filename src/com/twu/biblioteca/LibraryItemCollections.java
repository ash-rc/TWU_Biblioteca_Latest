package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashleycampo on 6/23/14.
 */
public class LibraryItemCollections {
    private LengthFinder lengthFinder;
    private PrintStream out;
    private List<LibraryItem> available;
    private List<LibraryItem> unavailable;

    public LibraryItemCollections(LengthFinder lengthFinder, PrintStream out, List<LibraryItem> available, List<LibraryItem> unavailable){
        this.lengthFinder = lengthFinder;
        this.out = out;
        this.available = available;
        this.unavailable = unavailable;
    }

    public void listItems() {
        int descriptorOffset = getLongestDescriptor() + 5;
        String printFormat = "%-" + descriptorOffset + "s %-" + descriptorOffset + "s %-" + descriptorOffset + "s %-4s\n";
        for(LibraryItem item : available) {
            out.printf(printFormat, item.getTitle(), item.getCreator(), item.getYear(), item.getRating());
        }
    }

    public void checkoutItem(String title){
        LibraryItem item = findItem(title, available);
        if(item != null){
            unavailable.add(item);
            available.remove(item);
            out.println("Thank you! Enjoy " + item.getTitle());
        } else {
            out.println("Item not available.");
        }
    }

    public LibraryItem findItem(String title, List<LibraryItem> items) {
        for(LibraryItem item : items) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public List<String> getDescriptorList() {
        List<String> descriptorList = new ArrayList<String>();
        for(LibraryItem item : available) {
            descriptorList.add(item.getCreator());
            descriptorList.add(item.getTitle());
        }
        return descriptorList;
    }

    public void returnItem(String title) {
        LibraryItem item = findItem(title, unavailable);
        if(item != null){
            available.add(item);
            unavailable.remove(item);
            out.println("Thank you for returning " + item.getTitle());
        } else {
            out.println("This is not a valid item return.");
        }
    }

    private int getLongestDescriptor(){
        return lengthFinder.findLongestString(getDescriptorList());
    }
}
