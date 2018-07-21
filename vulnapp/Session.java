package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences myPrefs;
    SharedPreferences.Editor myeditor;
    Context contxt;

    public Session(Context ctx){
        this.contxt = ctx;
        myPrefs = ctx.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        myeditor = myPrefs.edit();
    }

    public void setLoggedin(boolean loggedin){
        myeditor.putBoolean("loggedInmode",loggedin);
        myeditor.commit();
    }

    public boolean loggedin(){
        return myPrefs.getBoolean("loggedInmode", false);
    }
}
