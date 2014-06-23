package com.twu.biblioteca;

/**
 * Created by ashleycampo on 6/23/14.
 */
public class Movie implements LibraryItem {
    String title;
    String director;
    String year;
    String rating;

    public Movie(String title, String director, String year, String rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object _movie) {
        Movie movie = (Movie) _movie;

        return director.equals(movie.getCreator()) && title.equals(movie.getTitle()) && year.equals(movie.getYear());
    }

    @Override
    public LibraryItem getLibraryItem(String title) {
        if (this.title.equals(title)){
            return this;
        }
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public String getCreator() {
        return director;
    }

    @Override
    public String getRating() {
        return rating;
    }
}
