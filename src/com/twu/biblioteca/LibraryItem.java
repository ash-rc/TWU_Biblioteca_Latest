package com.twu.biblioteca;

/**
 * Created by ashleycampo on 6/23/14.
 */
public interface LibraryItem {

    public LibraryItem getLibraryItem(String item);
    public String getTitle();
    public String getYear();
    public String getCreator();
    public String getRating();
    @Override
    public boolean equals(Object _LibraryItem);


}
