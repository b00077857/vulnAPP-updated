package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Thread_dialog extends AppCompatActivity  {
    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    public TextView user;
    public TextView getthreadstr;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_dialog);
        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        user = (TextView) findViewById(R.id.usertxti);

        getthreadstr = (TextView) findViewById(R.id.textViewthread);

        String getid = myPrefs.getString("threadid", "0");
        String getusern = myPrefs.getString("senduser", "");
        String getpostdet1 = myPrefs.getString("from1postdet", "0");
        String getpostdet2 = myPrefs.getString("from2postdet", "0");
        String getpostdet3 = myPrefs.getString("from3postdet", "0");

        if(getid == "threadid1") {
            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

            String getrep1 = myPrefs.getString("thread1det", "");
            String getuser1 = myPrefs.getString("senduser", "");

           // LinearLayout rlthrd = (LinearLayout) findViewById(R.id.rl_thread);

         //   TextView threadrep1 = new TextView(getApplicationContext());

            /*

            RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(900, 1800);
            lp2.setMargins(30, 110, 0, 0);
            threadrep1.setLayoutParams(lp2);
            threadrep1.setText(getrep1);
            threadrep1.setTextColor(Color.parseColor("#fbef1b1b"));
            threadrep1.setTypeface(null, Typeface.BOLD);
            threadrep1.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);

            */
            String appendtopmessage = "Post: \n"+getpostdet1;
            user.setText(appendtopmessage);
            /*
            ImageView divider = new ImageView(this);
            RelativeLayout.LayoutParams lpDIVt = new RelativeLayout.LayoutParams(1200, 10);
            lpDIVt.setMargins(0, 180, 0, 0);
            divider.setLayoutParams(lpDIVt);
            divider.setBackgroundColor(Color.BLUE);

            rlthrd.addView(divider);
            */
         //   rlthrd.addView(threadrep1);

            getthreadstr.setText(getrep1);

        }

        else if(getid == "threadid2") {
            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

            String getrep2 = myPrefs.getString("thread2det", "");
            String getuser2 = myPrefs.getString("senduser", "");

/*
            RelativeLayout rlthrd2 = (RelativeLayout) findViewById(R.id.rl_thread);

            TextView threadrep2 = new TextView(getApplicationContext());
           // threadrep2.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(900, 1800);
            lp3.setMargins(30, 100, 0, 0);
            threadrep2.setLayoutParams(lp3);
            threadrep2.setText(getrep2);
            threadrep2.setTextColor(Color.parseColor("#fbef1b1b"));
            threadrep2.setTypeface(null, Typeface.BOLD);
            threadrep2.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);

*/
            String appendtopmessage = "Post: \n"+getpostdet2;
            user.setText(appendtopmessage);
            //user.setText("Replies to: "+getuser2);
/*
            ImageView divider = new ImageView(this);
            RelativeLayout.LayoutParams lpDIVt = new RelativeLayout.LayoutParams(1200, 10);
            lpDIVt.setMargins(0, 180, 0, 0);
            divider.setLayoutParams(lpDIVt);
            divider.setBackgroundColor(Color.BLUE);

            rlthrd2.addView(divider);
            rlthrd2.addView(threadrep2);
            */
            getthreadstr.setText(getrep2);
        }

        else if(getid == "threadid3") {
            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

            String getrep3 = myPrefs.getString("thread3det", "");
            String getuser3 = myPrefs.getString("senduser", "");
/*
            RelativeLayout rlthrd3 = (RelativeLayout) findViewById(R.id.rl_thread);

            TextView threadrep3 = new TextView(getApplicationContext());
           // threadrep3.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            RelativeLayout.LayoutParams lp4 = new RelativeLayout.LayoutParams(900, 1800);
            lp4.setMargins(30, 110, 0, 0);
            threadrep3.setLayoutParams(lp4);
            threadrep3.setText(getrep3);
            threadrep3.setTextColor(Color.parseColor("#fbef1b1b"));
            threadrep3.setTypeface(null, Typeface.BOLD);
            threadrep3.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
*/
            String appendtopmessage = "Post: \n"+getpostdet3;
            user.setText(appendtopmessage);
            //user.setText("Replies to: "+getuser3);
/*
            ImageView divider = new ImageView(this);
            RelativeLayout.LayoutParams lpDIVt = new RelativeLayout.LayoutParams(1200, 10);
            lpDIVt.setMargins(0, 180, 0, 0);
            divider.setLayoutParams(lpDIVt);
            divider.setBackgroundColor(Color.BLUE);

            rlthrd3.addView(divider);
            rlthrd3.addView(threadrep3);
*/
            getthreadstr.setText(getrep3);
        }
    }

}
