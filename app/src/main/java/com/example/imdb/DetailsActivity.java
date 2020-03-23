package com.example.imdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdb.MoviesList.MoviesListClass;
import com.example.imdb.MoviesList.Search;
import com.example.imdb.Probs.MovieProperties;
import com.example.imdb.Probs.Probs;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DetailsActivity extends AppCompatActivity {
    // TextView result, title, year, rated, releaseYear, runTime, genre, director;
    SavedDataBase db = new SavedDataBase(DetailsActivity.this, "SaveMoviesDB", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final TextView mtitle = findViewById(R.id.qtxtTitle);
//        TextView myear = findViewById(R.id.qtxtYear);
        final TextView mrated = findViewById(R.id.qtxtRated);
        final TextView mreleaseYear = findViewById(R.id.qtxtRelease);
        final TextView mrunTime = findViewById(R.id.qtxtRun);
        final TextView mgenre = findViewById(R.id.qtxtGenre);
        final TextView mdirector = findViewById(R.id.qtxtDirector);
        final Button savedb = findViewById(R.id.savedb);
        final ImageView imgCover = findViewById(R.id.imgCover);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String imdbId = intent.getStringExtra("id");
        String address = "http://www.omdbapi.com/?i=" + imdbId + "&apikey=70ad462a";
        // http://www.omdbapi.com/?s=gladiator&apikey=70ad462a
        // String address = "http://www.omdbapi.com/?s=" + title + "&apikey=b88d3738";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(address, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new Gson();
                MoviesListClass moviesListClass = gson.fromJson(response.toString(), MoviesListClass.class);
                MovieProperties moviesdetail = gson.fromJson(response.toString(), MovieProperties.class);
                final String title = moviesdetail.getTitle();
                final String rated = moviesdetail.getRated();
                final String releaseYear = moviesdetail.getReleased();
                final String runTime = moviesdetail.getRuntime();
                final String genre = moviesdetail.getGenre();
                final String director = moviesdetail.getDirector();
                final String cover = moviesdetail.getPoster();

                mtitle.setText("title " + title);
                mrated.setText("rated " + rated);
                mreleaseYear.setText("release " + releaseYear);
                mrunTime.setText("run time " + runTime);
                mgenre.setText("genre " + genre);
                mdirector.setText("director " + director);
                String coverUrl = cover;
                Picasso.get().load(coverUrl).into(imgCover);

                savedb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.insertMovie(title, releaseYear, rated, runTime, genre, director, cover);
                        Toast.makeText(DetailsActivity.this, "movie details saved!", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });









/*        Intent intent = getIntent();


        String id = intent.getStringExtra("id");
        result = findViewById(R.id.result);
        result.setText(id);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(id, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new Gson();
                MoviesListClass moviesListClass = gson.fromJson(response.toString(), MoviesListClass.class);
                RecyclerView recycler = findViewById(R.id.recycler);
                AdapterClass adapter = new AdapterClass(moviesListClass.getSearch());
                recycler.setAdapter(adapter);
                recycler.setLayoutManager(new LinearLayoutManager
                        (DetailsActivity.this, RecyclerView.VERTICAL, false));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });


//        String name = intent.getStringExtra("name");

        /*
        Search search = mylist.get(getAdapterPosition());
        Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
        intent.putExtra("id" , search.getImdbID());
        itemView.getContext().startActivity(intent); */
    }
}
