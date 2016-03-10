package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddMovie extends AppCompatActivity {

    @Bind(R.id.et_title) EditText etTitle;
    @Bind(R.id.et_year) EditText etYear;
    @Bind(R.id.et_director) EditText etDirector;
    @Bind(R.id.et_genre) EditText etGenre;
    @Bind(R.id.et_date_watched) EditText etDateWatched;
    @Bind(R.id.bt_save) Button btSave;
    @Bind(R.id.cb_on_watch_list) CheckBox cbOnWatchList;
    @Bind(R.id.et_rating) EditText etRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Boolean setOnWatchlist = getIntent().getBooleanExtra("setWatchList", false);

        if(setOnWatchlist) {
            cbOnWatchList.setChecked(true);
        } else {

        }


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

    @OnClick(R.id.bt_save)
    public void saveMovie(View view) {
        Movie movie = new Movie();

        movie.setTitle(etTitle.getText().toString());
        movie.setYearReleased(etYear.getText().toString());
        movie.setDirector(etDirector.getText().toString());
        movie.setGenre(etGenre.getText().toString());
        movie.setIsOnWatchList(cbOnWatchList.isChecked());

        movie.setRating(etRating.getText().toString());

        movie.save();

        //MainActivity.movies.add(movie);

        Intent intent = new Intent(AddMovie.this,MainActivity.class);
        startActivity(intent);


    }
}
