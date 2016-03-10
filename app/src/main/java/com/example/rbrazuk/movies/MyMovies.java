package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyMovies extends AppCompatActivity {

    @Bind(R.id.lv_movies) ListView lvMovies;
    ArrayList<Movie> myMovies;
    ArrayList<Movie> movies;
    static MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movies);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movies = MainActivity.movies;
        myMovies = new ArrayList<>();

        for(int i = 0;i < movies.size();i++) {
            Movie movie = movies.get(i);
            if(!movie.isOnWatchList()) {
                myMovies.add(movie);
            } else{

            }
        }

        adapter = new MoviesAdapter(this,myMovies);
        lvMovies.setAdapter(adapter);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyMovies.this,MovieDetail.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
            adapter.notifyDataSetChanged();

    }
}
