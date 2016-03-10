package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bt_movies) Button btMovies;
    @Bind(R.id.bt_watch_list) Button btWatchList;
    @Bind(R.id.bt_add_movie) Button btAddMovie;
    @Bind(R.id.tv_total_movies_watched) TextView tvMovieTotal;
    private int mMoviesWatched;

    public static ArrayList<Movie> movies;

    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);




        movies = new ArrayList<>();
        movies.add(new Movie());
        movies.get(0).setTitle("Vertigo");

        movies.get(0).setIsOnWatchList(true);

        movies.add(new Movie());
        movies.get(1).setTitle("North By Northwest");
        movies.get(1).setIsOnWatchList(false);


    }

    @Override
    protected void onResume() {
        super.onResume();
        moviesWatched(movies);
    }

    @OnClick (R.id.bt_movies)
    public void launchMyMovies(View view) {
        mIntent = new Intent(MainActivity.this,MyMovies.class);
        startActivity(mIntent);
    }

    @OnClick (R.id.bt_watch_list)
    public void launchWatchList(View view) {
        mIntent = new Intent(MainActivity.this,WatchList.class);
        startActivity(mIntent);
    }

    @OnClick (R.id.bt_add_movie)
    public void launchAddMovie(View view) {
        mIntent = new Intent(MainActivity.this,AddMovie.class);
        startActivity(mIntent);
    }

    private void moviesWatched(ArrayList<Movie> allMovies) {
        allMovies = MainActivity.movies;
        ArrayList<Movie> watchedMovies = new ArrayList<>();

        for(int i = 0;i < allMovies.size();i++) {
            Movie movie = movies.get(i);
            if(!movie.isOnWatchList()) {
                watchedMovies.add(movie);
            } else{

            }
        }
        tvMovieTotal.setText("Movies watched: " + String.valueOf(watchedMovies.size()));
    }

}
