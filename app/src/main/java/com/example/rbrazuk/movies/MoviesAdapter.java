package com.example.rbrazuk.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rossbrazuk1 on 3/9/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieView = inflater.inflate(R.layout.item_movie, parent, false);

        ViewHolder viewHolder = new ViewHolder(movieView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder holder, int position) {

        Movie movie = mMovies.get(position);

        TextView tvTitle = holder.tvTitle;
        tvTitle.setText(movie.getTitle());
        TextView tvRating = holder.tvRating;
        tvRating.setText(String.valueOf(movie.getRating()));

    }

    @Override
    public int getItemCount() {

        return mMovies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvRating;

        public ViewHolder(View itemView) {

            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvRating = (TextView) itemView.findViewById(R.id.tv_rating);

        }
    }

    private ArrayList<Movie> mMovies;

    public MoviesAdapter(ArrayList<Movie> movies) {
        mMovies = movies;
    }


}
