package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    private Button logoutbutton;
    private TextView t;
    public String loggedinuser;
    public TextView welcometext;

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String getname =  myPrefs.getString("nameStr","0");

        b1 = (Button) findViewById(R.id.chalB);
        b1.setOnClickListener(this);
        b2= (Button) findViewById(R.id.learnB);
        b2.setOnClickListener(this);
        b3= (Button) findViewById(R.id.resB);
        b3.setOnClickListener(this);
        b4= (Button) findViewById(R.id.forumB);
        b4.setOnClickListener(this);
        t = (TextView) findViewById(R.id.myTextView);
        welcometext = (TextView) findViewById(R.id.welcometxt);

        logoutbutton= (Button) findViewById(R.id.logoutB);
        logoutbutton.setOnClickListener(this);
        logoutbutton.setText("Logout");
        loggedinuser = getname;
        welcometext.setText("Hello "+loggedinuser + " !");
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.chalB:
             Intent i = new Intent(this, Scenarios.class);
             startActivity(i);
              break;

            case R.id.learnB:
            Intent i2 = new Intent(this, Guide.class);
            startActivity(i2);
                break;


            case R.id.resB:
                Intent i3 = new Intent(this, ResourceLinks.class);
                startActivity(i3);
                break;

            case R.id.logoutB:
                Intent i6 = new Intent(this, Register.class);
                startActivity(i6);
                break;

            case R.id.forumB:
                Intent i8 = new Intent(this, Forum.class);
                startActivity(i8);
                break;
            default:
                break;
        }
    }
}


/*
t.setText("Start Testing the Vulnerable Andriod Application");
 */