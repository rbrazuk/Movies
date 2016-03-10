package com.example.rbrazuk.movies;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rossbrazuk1 on 3/9/16.
 */
public class Movie extends SugarRecord {

    private String mTitle;
    private String mYearReleased;
    private String mDirector;
    private ArrayList<String> mActors;
    private String mDateWatched;
    private String rating;
    private String genre;
    public boolean isOnWatchList;

    public Movie(){

    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getYearReleased() {
        return mYearReleased;
    }

    public void setYearReleased(String yearReleased) {
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

    public String getDateWatched() {
        return mDateWatched;
    }

    public void setDateWatched(String dateWatched) {
        mDateWatched = dateWatched;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isOnWatchList() {
        return isOnWatchList;
    }

    public void setIsOnWatchList(boolean isOnWatchList) {
        this.isOnWatchList = isOnWatchList;
    }
}
