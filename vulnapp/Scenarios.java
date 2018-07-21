package com.example.mpe.vulnapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class Scenarios extends AppCompatActivity implements View.OnClickListener {

    private Button ch1b;
    private Button ch2b;
    private Button ch3b;
    private Button ch4b;
    private Button ch5b;
    private Button scoreCLb;
    private Button logoutbutton;


    public TextView stringscore;

    public String scoreString;
    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    public String getscorestring;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scenarios);

        ch1b = (Button) findViewById(R.id.ch1b);
        ch2b = (Button) findViewById(R.id.ch2b);
        ch3b = (Button) findViewById(R.id.ch3b);
        ch3b.setOnClickListener(this);

        ch4b = (Button) findViewById(R.id.ch4b);
        ch4b.setOnClickListener(this);

        scoreCLb = (Button) findViewById(R.id.clearScoreb);
        scoreCLb.setOnClickListener(this);

        ch1b.setOnClickListener(this);
        ch2b.setOnClickListener(this);   // calling onClick() method

        stringscore = (TextView) findViewById(R.id.scoreText);
        scoreString = stringscore.getText().toString();

        myPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        myeditor = myPrefs.edit();

        myeditor.commit();

        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String getname =  myPrefs.getString("nameStr","0");

        logoutbutton= (Button) findViewById(R.id.logoutB);
        logoutbutton.setOnClickListener(this);
        logoutbutton.setText(getname+" [Logout]");
    }

    protected  void onResume(){
        super.onResume();

        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String scoreforid =  myPrefs.getString("nameStr","0");

        //String testString = myPrefs.getString(getString(R.string.FlagScore),null);
        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String defaultString =  myPrefs.getString(scoreforid,"0");

        stringscore.setText(defaultString);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ch1b:
                Intent i1 = new Intent(this, CredentialStorage.class);
                startActivity(i1);
                break;

            case R.id.ch2b:
                Intent i2 = new Intent(this, VulnerableDatabase.class);
                startActivity(i2);
                break;

            case R.id.ch3b:
                Intent i8 = new Intent(this, Vulnerable_Access.class);
                startActivity(i8);
                break;

            case R.id.ch4b:
                Intent i10 = new Intent(this, PreloadedData.class);
                startActivity(i10);
                break;

            case R.id.clearScoreb:
                myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                String scoreforid =  myPrefs.getString("nameStr","0");

                myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                myeditor = myPrefs.edit();
                //String score = myPrefs.getString(getString(R.string.FlagScore), "1");
                //myeditor.putString(getString(R.string.FlagScore), "");
               // String score = myPrefs.getString("flagScore", "");
                myeditor.putString(scoreforid, "0");
                stringscore.setText("0");
                myeditor.commit();

                break;

            case R.id.logoutB:
                Intent i6 = new Intent(this, Register.class);
                startActivity(i6);
                break;

            default:
                break;
        }
    }


}
