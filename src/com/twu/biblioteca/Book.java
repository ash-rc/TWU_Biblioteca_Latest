package com.twu.biblioteca;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Book implements LibraryItem {
    String author;
    String year;
    String title;

    public Book(String title, String author, String year, String rating) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    @Override
    public boolean equals(Object _book) {
        Book book = (Book) _book;

        return author.equals(book.getCreator()) && title.equals(book.getTitle()) && year.equals(book.getYear());
    }

    @Override
    public LibraryItem getLibraryItem(String title) {
        if (this.title.equals(title)){
            return this;
        }
        return null;
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getYear(){
        return year;
    }

    @Override
    public String getCreator() {
        return author;
    }

    @Override
    public String getRating() { return ""; }

}
