package com.example.imdb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SpalshScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        EasySplashScreen splash = new EasySplashScreen(SpalshScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(EnterMovieInfoActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundColor(Color.parseColor("#FBB117"))
                //#FFD700</co
                //ld">#FBB117
                .withLogo(R.mipmap.imdb);
        View RunSplash =splash.create();
        setContentView(RunSplash);
        getSupportActionBar().hide();

    }
}
