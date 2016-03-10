package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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




        movies = (ArrayList)Movie.listAll(Movie.class);



    }

    @Override
    protected void onResume() {
        super.onResume();
        moviesWatched(movies);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_add:
                Intent intent= new Intent(MainActivity.this,AddMovie.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
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
