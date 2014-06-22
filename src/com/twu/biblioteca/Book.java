package com.twu.biblioteca;

/**
 * Created by ashleycampo on 6/17/14.
 */
public class Book {
    String author;
    String year;
    String title;

    public Book(String t, String a, String y) {
        author = a;
        year = y;
        title = t;
    }

    public String toString() {
        return (title + "\t" + author + "\t" + year);
    }

    @Override
    public boolean equals(Object _book) {
        Book book = (Book) _book;

        return author.equals(book.getAuthor()) && title.equals(book.getTitle()) && year.equals(book.getYear());


    }

    public Book getBook(String title){
        if (this.title.equals(title)){
            return this;
        }
        return null;
    }

    public String getTitle(){
        return title;
    }

    public String getYear(){
        return year;
    }

    public String getAuthor() {
        return author;
    }
}
