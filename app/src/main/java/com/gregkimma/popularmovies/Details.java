package com.gregkimma.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView movieImage = (ImageView) findViewById(R.id.movie_detail_image);
        int movieId = getIntent().getExtras().getInt("image", R.drawable.sample_0);
        movieImage.setImageResource(movieId);
    }
}
