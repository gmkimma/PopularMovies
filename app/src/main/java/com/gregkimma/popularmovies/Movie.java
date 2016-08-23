package com.gregkimma.popularmovies;

public class Movie {
    private String mTitle;
    private String mSynopsis;
    private String mRating;
    private String mReleaseDate;
    private String mImage;

    public Movie(String title, String synopsis, String rating, String releaseDate, String image) {
        mTitle = title;
        mSynopsis = synopsis;
        mRating = rating;
        mReleaseDate = releaseDate;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getRating() {
        return mRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getImage() {
        mImage = "http://image.tmdb.org/t/p/w185" + mImage;
        return mImage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mTitle='" + mTitle + '\'' +
                ", mSynopsis='" + mSynopsis + '\'' +
                ", mRating='" + mRating + '\'' +
                ", mReleaseDate='" + mReleaseDate + '\'' +
                ", mImage='" + mImage + '\'' +
                '}';
    }
}
