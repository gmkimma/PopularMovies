package com.gregkimma.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MoiveImageViewHolder>{

    private List<Movie> mMoviesList;
    private Context mContext;

    public MovieRecyclerViewAdapter(Context context, List<Movie> moviesList) {

        this.mContext = context;
        this.mMoviesList = moviesList;
    }

    @Override
    public MoiveImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse, null);
        MoiveImageViewHolder moiveImageViewHolder = new MoiveImageViewHolder(view);
        return moiveImageViewHolder;
    }

    @Override
    public int getItemCount() {
        return (null != mMoviesList ? mMoviesList.size() : 0);
    }
}
