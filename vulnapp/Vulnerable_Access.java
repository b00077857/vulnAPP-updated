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

public class Vulnerable_Access extends AppCompatActivity implements View.OnClickListener {


    private Button showinfo;
    public TextView infostr;
    public TextView vulnaccessdesc;
    public Button sendflagButton3;

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vulnerableaccess);

        showinfo = (Button) findViewById(R.id.showinfob2);
        showinfo.setOnClickListener(this);

        vulnaccessdesc = (TextView) findViewById(R.id.vulnaccessinfo);

        sendflagButton3 = (Button) findViewById(R.id.sendFlagB3);
        sendflagButton3.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showinfob2:
                Intent info1 = new Intent();
                info1.setAction("com.example.mpe.vulnapp.action.view_id");
                startActivity(info1);
                break;

            case R.id.sendFlagB3:
                EditText flaginput3 = (EditText) findViewById(R.id.flageditstr3);
                String flaginputstr =  flaginput3.getText().toString();

                try{
                    myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    String scoreforid =  myPrefs.getString("nameStr","0");

                    if(flaginputstr.equals("vulnaccesschal")) {
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
                    Log.d("VulnAPP- ", "Error occurred no Valid Flag "+flaginputstr + ee.getMessage());
                }

                break;

            default:
                break;
        }
    }
}


