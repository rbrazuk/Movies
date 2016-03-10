package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bt_movies) Button btMovies;
    @Bind(R.id.bt_watch_list) Button btWatchList;

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
}
