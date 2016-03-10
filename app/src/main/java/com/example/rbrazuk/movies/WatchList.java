package com.example.rbrazuk.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WatchList extends AppCompatActivity {


    @Bind(R.id.lv_watch_list) ListView lvWatchList;

    ArrayList<Movie> watchList;
    ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        watchList = new ArrayList<>();
        movies = MainActivity.movies;

        for(int i = 0; i < movies.size();i++) {
            Movie movie = movies.get(i);
            if(movie.isOnWatchList()) {
                watchList.add(movie);
            }
            else {

            }
        }

        System.out.println(watchList);



        MoviesAdapter adapter = new MoviesAdapter(this, watchList);
        lvWatchList.setAdapter(adapter);

        lvWatchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Movie movie = (Movie) parent.getItemAtPosition(position);
                movie.setIsOnWatchList(false);
            }
        });


    }
}
