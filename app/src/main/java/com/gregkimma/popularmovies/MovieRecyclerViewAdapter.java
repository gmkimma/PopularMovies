package com.gregkimma.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieImageViewHolder>{

    private List<Movie> mMoviesList;
    private Context mContext;

    public MovieRecyclerViewAdapter(Context context, List<Movie> moviesList) {

        this.mContext = context;
        this.mMoviesList = moviesList;
    }

    @Override
    public MovieImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse, null);
        MovieImageViewHolder movieImageViewHolder = new MovieImageViewHolder(view);
        return movieImageViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieImageViewHolder holder, int position) {

        Movie movieItem = mMoviesList.get(position);
        Log.d("Recyclerview", "Processing: " + movieItem.getTitle() + "-->" + Integer.toString(position));
        Picasso.with(mContext).load(movieItem.getImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return (null != mMoviesList ? mMoviesList.size() : 0);
    }

    public void loadNewData(List<Movie> newMovies) {
        mMoviesList = newMovies;
        notifyDataSetChanged();
    }

    public Movie getMovie(int position) {
        return (null != mMoviesList ? mMoviesList.get(position) : null);
    }
}
