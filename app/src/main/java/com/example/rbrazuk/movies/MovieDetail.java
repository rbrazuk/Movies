package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetail extends AppCompatActivity {

    @Bind(R.id.tv_movie_detail_title) TextView tvTitle;
    @Bind(R.id.tv_movie_detail_year) TextView tvYear;
    @Bind(R.id.tv_date_watched) TextView tvDateWatched;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Long idNumber = getIntent().getLongExtra(MyMovies.MOVIE_ID,-1L);
        System.out.println(idNumber);

        Movie movie = Movie.findById(Movie.class,idNumber);

        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYearReleased());
        tvDateWatched.setText(movie.getDateWatched());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
