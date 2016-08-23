package com.gregkimma.popularmovies;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetMovieJSONData extends GetRawData{

    private String TAG = GetMovieJSONData.class.getSimpleName();
    private List<Movie> mMovies;
    private Uri mDestinationUri;

    public GetMovieJSONData(String sortCriteria, String apiKey) {
        super(null);
        createAndUpdateUri(sortCriteria, apiKey);
        mMovies = new ArrayList<>();
    }

    public void execute() {
        super.setRawUrl(mDestinationUri.toString());
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        Log.v(TAG, "Built URI = " + mDestinationUri.toString());
        downloadJsonData.execute(mDestinationUri.toString());
    }

    public boolean createAndUpdateUri(String sortCriteria, String apiKey) {
        final String MOVIE_API_BASE_URL = "http://api.themoviedb.org/3/movie/" + sortCriteria;
        final String API_KEY = "api_key";

        mDestinationUri = Uri.parse(MOVIE_API_BASE_URL).buildUpon()
                .appendQueryParameter(API_KEY, apiKey)
                .build();

        return mDestinationUri != null;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void processResult() {
        if (getDownloadStatus() != DownloadStatus.OK) {
            Log.e(TAG, "Error downloading raw file");
            return;
        }

        final String MOVIE_RESULTS = "results";
        final String MOVIE_TITLE = "original_title";
        final String MOVIE_POSTER_URL = "poster_path";
        final String MOVIE_SYNOPSIS = "overview";
        final String MOVIE_RATING = "vote_average";
        final String MOVIE_RELEASE_DATE = "release_date";

        try {
            JSONObject jsonData = new JSONObject(getData());
            JSONArray resultsArray = jsonData.getJSONArray(MOVIE_RESULTS);
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject jsonMovie = resultsArray.getJSONObject(i);
                String title = jsonMovie.getString(MOVIE_TITLE);
                String synopsis = jsonMovie.getString(MOVIE_SYNOPSIS);
                String rating = jsonMovie.getString(MOVIE_RATING);
                String releaseDate = jsonMovie.getString(MOVIE_RELEASE_DATE);
                String posterUrl = jsonMovie.getString(MOVIE_POSTER_URL);

                Movie movieObject = new Movie(title, synopsis, rating, releaseDate, posterUrl);
                this.mMovies.add(movieObject);
            }

            for (Movie singleMovie : mMovies) {
                Log.v(TAG,singleMovie.toString());
            }
        } catch (JSONException jsone) {
            jsone.printStackTrace();
            Log.e(TAG, "Error processing JSON data");
        }
    }

    public class DownloadJsonData extends DownloadRawData {

        protected void onPostExecute(String webData) {
            super.onPostExecute(webData);
            processResult();
        }

        protected String doInBackground(String... params) {
            String[] par = {mDestinationUri.toString()};
            return super.doInBackground(params);
        }
    }

}
