package com.example.rbrazuk.movies;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddMovie extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {

    @Bind(R.id.et_title) EditText etTitle;
    @Bind(R.id.et_year) EditText etYear;
    @Bind(R.id.et_director) EditText etDirector;
    @Bind(R.id.et_genre) EditText etGenre;
    @Bind(R.id.et_date_watched) EditText etDateWatched;
    @Bind(R.id.bt_save) Button btSave;
    @Bind(R.id.cb_on_watch_list) CheckBox cbOnWatchList;
    @Bind(R.id.sp_rating) Spinner ratingSpinner;

    static String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        ButterKnife.bind(this);

        Boolean setOnWatchlist = getIntent().getBooleanExtra("setWatchList", false);

        if(setOnWatchlist) {
            cbOnWatchList.setChecked(true);
        } else {

        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ratings,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ratingSpinner.setAdapter(adapter);
        ratingSpinner.setOnItemSelectedListener(this);




    }

    @OnClick(R.id.et_date_watched)
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-FF");
        System.out.println(format.format(c.getTime()));
        etDateWatched.setText(format.format(c.getTime()));



    }

    @OnClick(R.id.bt_save)
    public void saveMovie(View view) {
        Movie movie = new Movie();

        movie.setTitle(etTitle.getText().toString());
        movie.setYearReleased(etYear.getText().toString());
        movie.setDirector(etDirector.getText().toString());
        movie.setGenre(etGenre.getText().toString());
        movie.setIsOnWatchList(cbOnWatchList.isChecked());
        movie.setDateWatched(etDateWatched.getText().toString());
        movie.setRating(rating);

        //movie.save();

        Firebase ref = new Firebase("https://rcbmovieapp.firebaseio.com/");

        Firebase movieRef = ref.child("movies");

        movieRef.push().setValue(movie);

        Intent intent = new Intent(AddMovie.this,MainActivity.class);
        startActivity(intent);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selectedItem = (String) parent.getItemAtPosition(position);

        System.out.println(selectedItem);

        if(TextUtils.equals(selectedItem,"set rating")) {
            rating = null;
        } else {
            rating = (String) parent.getItemAtPosition(position);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

