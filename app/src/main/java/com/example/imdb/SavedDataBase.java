package com.example.imdb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.imdb.Probs.Probs;

import java.util.ArrayList;
import java.util.List;

public class SavedDataBase extends SQLiteOpenHelper {
    String TABLE_NAME = "moviesData";


    public SavedDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String MOVIES_TABLE_QUERY = " CREATE TABLE " + TABLE_NAME + "(" +
                "_id INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT," +
                "year TEXT," +
                "rated TEXT," +
                "runTime TEXT," +
                "genre TEXT," +
                "director TEXT," +
                "cover TEXT"
                + ")";
        db.execSQL(MOVIES_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertMovie(String title, String year, String rated, String runTime, String genre, String director, String cover) {
        String INSERT_MOVIE_QUERY = " INSERT INTO " + TABLE_NAME + "(title, year, rated, runTime, genre, director, cover) VALUES("
                + "'" + title + "'" + ","
                + "'" + year + "'" + ","
                + "'" + rated + "'" + ","
                + "'" + runTime + "'" + ","
                + "'" + genre + "'" + ","
                + "'" + director + "'" + ","
                + "'" + cover + "'" +
                ")";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(INSERT_MOVIE_QUERY);
//        db.close();
    }

    public List<Probs> getMoviesDB() {
        List<Probs> mlist = new ArrayList<>();
        String GET_ALL_MOVIE = " SELECT title,year,rated,runTime,genre,director,cover FROM " + TABLE_NAME;
        Probs mProperties;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(GET_ALL_MOVIE, null);
        while (c.moveToNext()) {
            mProperties = new Probs();
            mProperties.setTitle(c.getString(0));
            mProperties.setYear(c.getString(1));
            mProperties.setRated(c.getString(2));
//            mProperties.setReleased(c.getString(3));
            mProperties.setRuntime(c.getString(3));
            mProperties.setGenre(c.getString(4));
            mProperties.setDirector(c.getString(5));
            mProperties.setPoster(c.getString(6));
            mlist.add(mProperties);
        }

        return mlist;
    }
}
