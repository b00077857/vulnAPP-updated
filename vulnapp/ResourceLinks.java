package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResourceLinks extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;
    private Button logoutbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resourcelinks);

        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String getname =  myPrefs.getString("nameStr","0");

        logoutbutton= (Button) findViewById(R.id.logoutB);
        logoutbutton.setOnClickListener(this);
        logoutbutton.setText(getname+" [Logout]");

        TextView resolink = (TextView) findViewById(R.id.resourceLinkb);
        resolink.setMovementMethod(LinkMovementMethod.getInstance());


        TextView apklink = (TextView) findViewById(R.id.apklinkb);
        apklink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onClick(View v) {

            switch (v.getId()) {

                case R.id.logoutB:
                    Intent i6 = new Intent(this, Register.class);
                    startActivity(i6);
                    break;
                default:
                    break;
            }

    }
}
