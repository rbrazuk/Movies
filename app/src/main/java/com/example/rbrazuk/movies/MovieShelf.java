package com.example.rbrazuk.movies;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MovieShelf {
    private static MovieShelf sMovieShelf;

    private List<Movie> mMovies;

    public static MovieShelf get(Context context) {
        if (sMovieShelf == null) {
            sMovieShelf = new MovieShelf(context);
        }
        return sMovieShelf;
    }

    private MovieShelf(Context context) {
        mMovies = new ArrayList<>();
    }

    public List<Movie> getMovies() {
        return Movie.listAll(Movie.class);
    }
}
