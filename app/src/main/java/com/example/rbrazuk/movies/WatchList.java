package com.example.rbrazuk.movies;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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

        updateData();

        System.out.println(watchList);



        final MoviesAdapter adapter = new MoviesAdapter(this, watchList);
        lvWatchList.setAdapter(adapter);

        lvWatchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Movie movie = (Movie) parent.getItemAtPosition(position);
                movie.setIsOnWatchList(false);
                watchList.remove(movie);
                adapter.remove(movie);
                adapter.notifyDataSetChanged();
                updateData();



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
                Intent intent= new Intent(WatchList.this,AddMovie.class);
                intent.putExtra("setWatchList",true);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateData(){
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
    }
}
