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


public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button regB;
    private Button loginB;

    private Database db;
    public EditText nametext;
    public EditText passtext;
    private Session session;

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        session = new Session(this);
        nametext = (EditText) findViewById(R.id.nametext);
        passtext = (EditText) findViewById(R.id.passtext);

        regB = (Button) findViewById(R.id.regB);
        regB.setOnClickListener(this);

        loginB = (Button) findViewById(R.id.logiB);
        loginB.setOnClickListener(this);

        db = new Database(this);

        if(session.loggedin()){
           // Intent i3 = new Intent(this, MainActivity.class);
           // startActivity(i3);
        }

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.regB:
                register();
                break;
            case R.id.logiB:
                login();
                break;
            default:
                break;
        }
    }

    private void register() {
        String getname = nametext.getText().toString();
        String getpass = passtext.getText().toString();
        if (getname.isEmpty() && getpass.isEmpty()) {
            displayToast("Username/password field empty");
        } else {
            db.addUser(getname, getpass);
            displayToast("You have registered");
        }
    }

    private void login() {
        String logname = nametext.getText().toString();
        String logpass = passtext.getText().toString();

        if (db.getUser(logname, logpass)) {
            session.setLoggedin(true);
            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            myeditor = myPrefs.edit();
            myeditor.putString("nameStr", logname);
            myeditor.commit();
            Intent i4 = new Intent(this, MainActivity.class);
            startActivity(i4);


        } else {
            Toast.makeText(getApplicationContext(), "Wrong Username/Password, Retry!", Toast.LENGTH_SHORT).show();
        }

    }

    private void displayToast (String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
