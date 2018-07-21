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

public class Guide extends AppCompatActivity implements View.OnClickListener {

    private Button ex1;
    private Button ex2;
    private Button ex3;
    private Button logoutbutton;

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String getname =  myPrefs.getString("nameStr","0");

        ex1 = (Button) findViewById(R.id.vuln1b);
        ex1.setOnClickListener(this);

        ex2 = (Button) findViewById(R.id.vuln2b);
        ex2.setOnClickListener(this);

        ex3 = (Button) findViewById(R.id.vuln3b);
        ex3.setOnClickListener(this);

        logoutbutton= (Button) findViewById(R.id.logoutB);
        logoutbutton.setOnClickListener(this);
        logoutbutton.setText(getname+" [Logout]");

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.vuln1b:
                Intent i1 = new Intent(this, LearnLogging.class);
                startActivity(i1);
                break;

            case R.id.vuln2b:
                Intent i2 = new Intent(this, LearnSQL.class);
                startActivity(i2);
                break;

            case R.id.vuln3b:
                Intent i11 = new Intent(this, LearnDataExposure.class);
                startActivity(i11);
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
