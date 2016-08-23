package com.gregkimma.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("MOVIE_TRANSFER");

        TextView movieTitle = (TextView) findViewById(R.id.movie_title);
        movieTitle.setText(movie.getTitle());

        TextView releaseDate = (TextView) findViewById(R.id.release_date);
        releaseDate.setText(movie.getReleaseDate());

        TextView synopsis = (TextView) findViewById(R.id.synopsis);
        synopsis.setText(movie.getSynopsis());

        TextView rating = (TextView) findViewById(R.id.rating);
        String ratingText = movie.getRating() + "/10";
        rating.setText(ratingText);

        ImageView moviePoster = (ImageView) findViewById(R.id.movie_detail_image);
        Picasso.with(this).load(movie.getImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(moviePoster);
    }
}
