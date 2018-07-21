package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PreloadedData extends AppCompatActivity implements View.OnClickListener{

    private Button datasendB;
    public TextView getservernamestr;
    public TextView preloadeddatadesc;
    public Button sendflagButton4;

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preloadeddata);

        datasendB = (Button) findViewById(R.id.servernameB);
        datasendB.setOnClickListener(this);

        preloadeddatadesc = (TextView) findViewById(R.id.vulnaccessinfo);
        getservernamestr = (TextView) findViewById(R.id.servernamestr);

        sendflagButton4 = (Button) findViewById(R.id.sendFlagB4);
        sendflagButton4.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.servernameB:
                if(getservernamestr.equals("server1.shop4all.com")){
                    Toast.makeText(this, "You've Found the server!" , Toast.LENGTH_SHORT).show();
                          /**************      FLAG: exposeddata *****************/
                }

                break;

            case R.id.sendFlagB4:
                EditText flaginput4 = (EditText) findViewById(R.id.flageditstr4);
                String flaginputstr4 =  flaginput4.getText().toString();

                try{
                    myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    String scoreforid =  myPrefs.getString("nameStr","0");

                    if(flaginputstr4.equals("exposeddata")) {
                        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                        myeditor = myPrefs.edit();

                        String combstat = myPrefs.getString(scoreforid + " chalstat", "0");

                        String defaultString2 = myPrefs.getString(scoreforid, "1");
                        Integer curScore = Integer.parseInt(defaultString2);
                        Integer upScore = curScore + 1;
                        String newScore = Integer.toString(upScore);
                        myeditor.putString(scoreforid, newScore);
                        myeditor.commit();
                        Toast.makeText(this, "Score now - " + newScore, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Incorrect Flag, Try again!", Toast.LENGTH_SHORT).show();
                    }

                }
                catch (Exception ee){
                    Log.d("VulnAPP- ", "Error occurred no Valid Flag "+flaginputstr4 + ee.getMessage());
                }

                break;

            default:
                break;
        }
    }
}

