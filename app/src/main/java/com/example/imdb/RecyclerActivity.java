package com.example.imdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.imdb.MoviesList.MoviesListClass;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String imdbId = intent.getStringExtra("id");
        String address = "http://www.omdbapi.com/?s=" + title+ "&apikey=70ad462a";
        // http://www.omdbapi.com/?s=gladiator&apikey=70ad462a
        // String address = "http://www.omdbapi.com/?s=" + title + "&apikey=b88d3738";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(address, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new Gson();
                MoviesListClass moviesListClass = gson.fromJson(response.toString(), MoviesListClass.class);
                RecyclerView recycler = findViewById(R.id.recycler);
                AdapterClass adapter = new AdapterClass(moviesListClass.getSearch());
                recycler.setAdapter(adapter);
                recycler.setLayoutManager(new LinearLayoutManager
                        (RecyclerActivity.this, RecyclerView.VERTICAL, false));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }
}
