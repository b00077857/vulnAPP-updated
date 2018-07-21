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
import android.widget.Toast;

public class CredentialStorage extends AppCompatActivity implements View.OnClickListener{

    private Button chkmb;
    public Button sendFlagbutton;
   // public String flaginput;

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;
    public EditText flageditstr;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentialstorage);

        chkmb = (Button) findViewById(R.id.chkb);
        chkmb.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sendFlagbutton = (Button) findViewById(R.id.sendFlagB);
        sendFlagbutton.setOnClickListener(this);

        flageditstr = (EditText) findViewById(R.id.flagedit);



    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.chkb:
                EditText pacstr = (EditText) findViewById(R.id.pacStr);
                try {
                   // processPAC(pacstr.getText().toString());
                    myeditor.commit();
                } catch (RuntimeException re) {
                    Log.e("vulnapplog-", "Invalid PAC: " + pacstr.getText().toString());
                    Toast.makeText(this, "Invalid access code. Re-enter PAC"+pacstr.getText().toString(), Toast.LENGTH_SHORT).show();
                                    /**************      FLAG: vulnlogschallenge *****************/
                }
                break;

            default:
                break;
        }
        switch (v.getId()) {

            case R.id.sendFlagB:
                String flaginput =  flageditstr.getText().toString();
                try {
                    myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    String scoreforid =  myPrefs.getString("nameStr","0");
                        if(flaginput.equals("vulnlogchallenge")) {
                            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                            myeditor = myPrefs.edit();
                            myeditor.putString("chalstat", "0");
                            myeditor.commit();
                            String userstat =  myPrefs.getString("chalstat","0");
                            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

                            String getcombstat =  myPrefs.getString("statcomb","0");
                            String finalstat = getcombstat.substring(getcombstat.lastIndexOf("+") + 1);

                             //    myeditor.putString("chalstat", "1");
                             //    myeditor.commit();
                                 String combstat =  myPrefs.getString(scoreforid+" chalstat","0");
                               //  myeditor.putString("statcomb", combstat);
                                 myeditor.putString("statcomb", "0");
                                myeditor.putString("chal1chk", "1");
                                 myeditor.commit();

                                // Toast.makeText(this, "Score now - "+finalstat, Toast.LENGTH_SHORT).show();

                                 String defaultString =  myPrefs.getString(scoreforid,"1");
                                 Integer curScore = Integer.parseInt(defaultString);
                                 Integer upScore = curScore + 1;
                                 String newScore = Integer.toString(upScore);
                                 myeditor.putString(scoreforid, newScore);
                                 myeditor.commit();
                                 Toast.makeText(this, "Flag Scored >>"+newScore, Toast.LENGTH_SHORT).show();


                        }
                        else{
                            Toast.makeText(this, "Incorrect Flag, Try again!", Toast.LENGTH_SHORT).show();
                        }


                } catch (RuntimeException re) {
                }
                break;

            default:
                break;
        }
    }



    private void processPAC(String pacstring) {
        RuntimeException e = new RuntimeException();
        throw e;
    }
}
