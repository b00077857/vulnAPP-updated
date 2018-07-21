package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VulnerableDatabase extends AppCompatActivity implements View.OnClickListener{

    private SQLiteDatabase myDB;
    public Button searchb;
    public Button sendflagButton;

    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            myDB = openOrCreateDatabase("sqli", MODE_PRIVATE, null);
            myDB.execSQL("DROP TABLE IF EXISTS sqliuser;");
            myDB.execSQL("CREATE TABLE IF NOT EXISTS sqliuser(username VARCHAR, password VARCHAR, address VARCHAR);");
            myDB.execSQL("INSERT INTO sqliuser VALUES ('Jenny', 'JennyGahn2018Password', '123,ValkenStreet,Dublin-12');");
            myDB.execSQL("INSERT INTO sqliuser VALUES ('admin', 'vulnerablePass2018', '567,BlackPool-Industrial-Estate,Cork');");
            myDB.execSQL("INSERT INTO sqliuser VALUES ('', 'Challenge Flag: notasecuredb', '');");

        }
        catch(Exception e) {
            Log.d("VulnAPP- ", "Error occurred while creating database for SQLI: " + e.getMessage());
        }
        setContentView(R.layout.activity_vulnerabledb);

        searchb = (Button) findViewById(R.id.searchB);
        searchb.setOnClickListener(this);

        sendflagButton = (Button) findViewById(R.id.sendFlagB2);
        sendflagButton.setOnClickListener(this);

    }


    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.searchB:
                EditText searchFi = (EditText) findViewById(R.id.searchF);
                Cursor cr = null;
                try {
                    cr = myDB.rawQuery("SELECT * FROM sqliuser WHERE username = '" + searchFi.getText().toString() + "'", null);
                    StringBuilder strbuilder = new StringBuilder("");
                    if ((cr != null) && (cr.getCount() > 0)) {
                        cr.moveToFirst();

                        do {
                            strbuilder.append("User: (" + cr.getString(0) + ") pass: (" + cr.getString(1) + ") Address: (" + cr.getString(2) + ")\n\n");
                        } while (cr.moveToNext());
                    }
                    else {
                        strbuilder.append("Author or Book: (" + searchFi.getText().toString() +") not found");
                    }
                    Toast.makeText(this, strbuilder.toString(), Toast.LENGTH_LONG).show();
                }
                catch(Exception e) {
                    //Log.d("VulnAPP- ", "Error occurred on searching DB " + e.getMessage());
                    Toast.makeText(this, "Error occurred on searching library users DB \n\n"+ e.getMessage(), Toast.LENGTH_LONG).show();

                }
                break;
            case R.id.sendFlagB2:
                EditText flageditstr = (EditText) findViewById(R.id.sendFlagedit2);
                String flaginput =  flageditstr.getText().toString();

                    try{
                        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                        String scoreforid =  myPrefs.getString("nameStr","0");

                        //Toast.makeText(this, "Name!"+scoreforid, Toast.LENGTH_SHORT).show();

                        if(flaginput.equals("notasecuredb")) {
                            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                            myeditor = myPrefs.edit();
                            String userstat =  myPrefs.getString("chalstat","0");
                           // myeditor.putString("chalstat", "0");
                          //  myeditor.commit();
                            String getstatchal2 = myPrefs.getString("chal2chk", "0");
                            String getcombstat = myPrefs.getString("statcomb", "0");

                                //     myeditor.putString("chalstat", "1");
                                //    myeditor.commit();
                                // String statcomb = scoreforid + "+ " + userstat;
                                //   String combstat = myPrefs.getString("fullstat", "0");

                                String combstat = myPrefs.getString(scoreforid + " chalstat", "0");

                               // myeditor.putString("statcomb", combstat);
                                myeditor.putString("statcomb", "1");
                                myeditor.putString("chal2chk", "1");
                                myeditor.commit();

                                String fullstatcomb = myPrefs.getString("statcomb", "0");
                                String finalstat = fullstatcomb.substring(fullstatcomb.lastIndexOf("+") + 1);

                                String defaultString = myPrefs.getString(scoreforid, "1");
                                Integer curScore = Integer.parseInt(defaultString);
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
                        Log.d("VulnAPP- ", "Error occurred no Valid Flag "+flaginput + ee.getMessage());
                    }
                //String score = myPrefs.getString(getString(R.string.FlagScore), "1");
                //myeditor.putString("flagScore", "1");
                //myeditor.putString(getString(R.string.FlagScore), "");
                break;

            default:
                break;
        }
    }

}
