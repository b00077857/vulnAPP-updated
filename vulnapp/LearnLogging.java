package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;

public class LearnLogging extends AppCompatActivity implements View.OnClickListener{

    PhotoViewAttacher pAttacher;
    private ImageView imageViewlog;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnlogging);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageViewlog = (ImageView) findViewById(R.id.imageView1);

        pAttacher = new PhotoViewAttacher(imageViewlog);
        pAttacher.update();
    }

    public void onClick(View v) {

    }
}
