package com.example.imdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterMovieInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_movie_info);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnDataBase = findViewById(R.id.btnDataBase);
        final EditText btnTitle = findViewById(R.id.btnTitle);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btnTitle.getText().toString().equals("")) {
                    String Title = btnTitle.getText().toString();
                    Intent intent = new Intent(EnterMovieInfoActivity.this, RecyclerActivity.class);
                    intent.putExtra("title", Title);
                    startActivity(intent);
                }
            }
        });
        btnDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datapage = new Intent(EnterMovieInfoActivity.this, SearchedMoviesActivity.class);
                startActivity(datapage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent howpage = new Intent(EnterMovieInfoActivity.this, AboutActivity.class);
                startActivity(howpage);
                break;
            case R.id.item2:
                AlertDialog alertDialog = new AlertDialog.Builder(EnterMovieInfoActivity.this)
                        .setTitle("Warning")
                        .setMessage("Do you want to leave?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                System.exit(0);
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setNeutralButton("About us", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent con = new Intent(EnterMovieInfoActivity.this, CreatorActivity.class);
                                startActivity(con);
                            }
                        }).create();
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
