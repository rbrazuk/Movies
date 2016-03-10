package com.example.rbrazuk.movies;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rossbrazuk1 on 3/10/16.
 */
public class WatchListAdapter extends ArrayAdapter<Movie> {
    public WatchListAdapter(Context context,ArrayList<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent,false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);

        tvTitle.setText(movie.getTitle());





        return convertView;
    }
}
