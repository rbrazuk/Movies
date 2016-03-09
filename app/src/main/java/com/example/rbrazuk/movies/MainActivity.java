package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bt_movies) Button btMovies;
    @Bind(R.id.bt_watch_list) Button btWatchList;

    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
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
