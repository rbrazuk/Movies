package com.example.rbrazuk.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyMovies extends AppCompatActivity {

    @Bind(R.id.rv_movies) RecyclerView rvMovies;
    ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movies);

        ButterKnife.bind(this);

        movies = new ArrayList<>();
        movies.add(new Movie());
        movies.get(0).setTitle("Star Wars");
        movies.get(0).setRating(5);

        movies.add(new Movie());
        movies.get(1).setTitle("12 Monkeys");
        movies.get(1).setRating(4);

        MoviesAdapter adapter = new MoviesAdapter(movies);
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }
}
