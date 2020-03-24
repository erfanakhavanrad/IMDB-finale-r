package com.example.imdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.imdb.MoviesList.Search;
import com.example.imdb.Probs.Probs;

import java.util.ArrayList;
import java.util.List;

public class SearchedMoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        RecyclerView recycler = findViewById(R.id.recycler);
        final SavedDataBase db = new SavedDataBase(SearchedMoviesActivity.this, "SaveMoviesDB", null, 1);


        List<Probs> searchedList = new ArrayList<>();
        searchedList = db.getMoviesDB();
        DetailAdapter dadapter = new DetailAdapter(searchedList);
//        AdapterClass adapter = new AdapterClass(searchedList);
        recycler.setAdapter(dadapter);


        recycler.setLayoutManager(new LinearLayoutManager(SearchedMoviesActivity.this
                , RecyclerView.VERTICAL, false));
    }
}
