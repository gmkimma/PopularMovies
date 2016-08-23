package com.gregkimma.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class MoiveImageViewHolder extends RecyclerView.ViewHolder {

    protected ImageView thumbnail;

    public MoiveImageViewHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
    }

}
