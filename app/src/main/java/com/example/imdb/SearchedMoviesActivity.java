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
        setContentView(R.layout.searched_movies_items);



        RecyclerView recycler = findViewById(R.id.recycler);
        final SavedDataBase db = new SavedDataBase(SearchedMoviesActivity.this ,"Imdb", null, 1);












        List<Probs> searchedList = new ArrayList<>();
        searchedList = db.getMoviesDB();
//        AdapterClass adapter = new AdapterClass();
//        recycler.setAdapter(adapter);





























        recycler.setLayoutManager(new LinearLayoutManager(SearchedMoviesActivity.this
                , RecyclerView.VERTICAL, false));

        String s = "RecyclerView recycler = findViewById(R.id.searchedRecycler);\n" +
                "        final ImdbDatabase db = new ImdbDatabase(SearchedMovieActivity.this, \"Imdb\", null, 1);\n" +
                "        List<MovieProperties> searchedList = new ArrayList<>();\n" +
                "        searchedList = db.getMoviesDB();\n" +
                "        SearchedAdapter adapter = new SearchedAdapter(searchedList);\n" +
                "        recycler.setAdapter(adapter);\n" +
                "        recycler.setLayoutManager(new LinearLayoutManager(SearchedMovieActivity.this\n" +
                "                , RecyclerView.VERTICAL, false));";

    }
}
