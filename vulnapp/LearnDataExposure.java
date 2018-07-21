package com.example.mpe.vulnapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class LearnDataExposure extends AppCompatActivity{

    PhotoViewAttacher pAttacher;
    private ImageView imageintent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learndataexposure);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageintent = (ImageView) findViewById(R.id.imageView2);
        pAttacher = new PhotoViewAttacher(imageintent);
        pAttacher.update();
    }

}
