package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyMovies extends AppCompatActivity {

    @Bind(R.id.lv_movies) ListView lvMovies;

    ArrayList<Movie> movies;
    static MoviesAdapter adapter;
    ArrayList myMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movies);

        ButterKnife.bind(this);

        movies = (ArrayList) MovieShelf.get(this).getMovies();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        updateData();

        adapter = new MoviesAdapter(this,myMovies);
        lvMovies.setAdapter(adapter);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Intent intent = new Intent(MyMovies.this, MovieDetail.class);
                //startActivity(intent);
            }
        });

        lvMovies.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = (Movie) parent.getItemAtPosition(position);


                movies.remove(movie);
                adapter.remove(movie);
                movie.delete();
                adapter.notifyDataSetChanged();
                updateData();

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
            updateData();

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
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_add:
                Intent intent= new Intent(MyMovies.this,AddMovie.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateData() {
        movies = (ArrayList<Movie>) MovieShelf.get(this).getMovies();
        myMovies = new ArrayList<>();

        for(int i = 0;i < movies.size();i++) {
            Movie movie = movies.get(i);
            if(!movie.isOnWatchList()) {
                myMovies.add(movie);
            } else{

            }
        }
    }
}
