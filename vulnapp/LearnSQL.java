package com.example.mpe.vulnapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;

public class LearnSQL extends AppCompatActivity implements View.OnClickListener {

    private Button sendinputsqlb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learndatabase);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sendinputsqlb = (Button) findViewById(R.id.sendinputsql);
        sendinputsqlb.setOnClickListener(this);

        }

    public void onClick(View v) {
        EditText sendinputsqlstr = (EditText) findViewById(R.id.getinputdbl);
        String getinputsqlstr =  sendinputsqlstr.getText().toString();

        switch (v.getId()) {
            case R.id.sendinputsql:
                try {
                    if (getinputsqlstr.equals("\"\'")) {
                        Toast.makeText(this, "Error while searching in database: unrecognized input: “‘”’‘” (code 1): , while compiling: SELECT * FROM USERDB WHERE password = ‘”’‘ AND ID = ‘”’‘", Toast.LENGTH_LONG).show();
                    } else if (getinputsqlstr.equals("1\' or \'1\' != \'2")) {
                        Toast.makeText(this, "password: (secretpass2018) ID: (224)", Toast.LENGTH_LONG).show();
                    }
                    break;
                }
                catch (RuntimeException re){

            }
            default:
                break;
        }
    }
}
