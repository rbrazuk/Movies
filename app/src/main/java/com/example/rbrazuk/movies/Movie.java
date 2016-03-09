package com.example.rbrazuk.movies;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rossbrazuk1 on 3/9/16.
 */
public class Movie {

    private String mTitle;
    private int mYearReleased;
    private String mDirector;
    private ArrayList<String> mActors;
    private Date mDateWatched;
    private int rating;
    private String genre;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getYearReleased() {
        return mYearReleased;
    }

    public void setYearReleased(int yearReleased) {
        mYearReleased = yearReleased;
    }

    public String getDirector() {
        return mDirector;
    }

    public void setDirector(String director) {
        mDirector = director;
    }

    public ArrayList<String> getActors() {
        return mActors;
    }

    public void setActors(ArrayList<String> actors) {
        mActors = actors;
    }

    public Date getDateWatched() {
        return mDateWatched;
    }

    public void setDateWatched(Date dateWatched) {
        mDateWatched = dateWatched;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}