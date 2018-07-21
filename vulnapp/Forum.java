package com.example.mpe.vulnapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Forum  extends AppCompatActivity implements View.OnClickListener{

    public Button logoutButton;
    public Button newtopic;
    public Button reply1b;
    public Button reply2b;
    public Button reply3b;
    public Button thread1;
    public Button thread2;
    public Button thread3;
    public Button cleardisc;

    private TextView t;
    public String loggedinuser;
    public TextView loggstattext;
  //  public String m_Text = "";
    public TextView postid1;
    public TextView postid2;
    public TextView postid3;
    public TextView cantmsg;


    SharedPreferences myPrefs;
    public SharedPreferences.Editor myeditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum);
        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        logoutButton= (Button) findViewById(R.id.logoutB);
        logoutButton.setOnClickListener(this);

        newtopic = (Button) findViewById(R.id.newtopicB);
        newtopic.setOnClickListener(this);

        reply1b = (Button) findViewById(R.id.reply1);
        reply1b.setOnClickListener(this);

        reply2b = (Button) findViewById(R.id.reply2);
        reply2b.setOnClickListener(this);

        reply3b = (Button) findViewById(R.id.reply3);
        reply3b.setOnClickListener(this);

        thread1 = (Button) findViewById(R.id.thread1);
        thread1.setOnClickListener(this);

        thread2 = (Button) findViewById(R.id.thread2);
        thread2.setOnClickListener(this);

        thread3 = (Button) findViewById(R.id.thread3);
        thread3.setOnClickListener(this);

        cleardisc = (Button) findViewById(R.id.cleardiscB);
        cleardisc.setOnClickListener(this);

        loggstattext = (TextView) findViewById(R.id.logstatText);
        String getname =  myPrefs.getString("nameStr","0");
        loggedinuser = getname;
        loggstattext.setText("Logged-In as "+getname);

        postid1 = (TextView) findViewById(R.id.postno1);
        postid2 = (TextView) findViewById(R.id.postno2);
        postid3 = (TextView) findViewById(R.id.postno3);
        cantmsg = (TextView) findViewById(R.id.cantpost);


    }

    protected  void onResume(){
        super.onResume();

        if(loggedinuser.equals("tom")|| loggedinuser.equals("tim") ||
                loggedinuser.equals("john")){
            newtopic.setVisibility(View.VISIBLE);
            cantmsg.setVisibility(View.GONE);
        }
        else if(!loggedinuser.equals("tom")|| !loggedinuser.equals("tim") ||
                !loggedinuser.equals("john")) {
            newtopic.setVisibility(View.GONE);

            cantmsg.setText("Sorry You can't post new topics yet! "+loggedinuser);
        }

        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String getpostrn1 = myPrefs.getString("from1postdet","");
        postid1.setText("#1"+"\n"+getpostrn1);

        String getpostrn2 = myPrefs.getString("from2postdet","");
        postid2.setText("#2"+"\n"+getpostrn2);

        String getpostrn3 = myPrefs.getString("from3postdet","");
        postid3.setText("#3"+"\n"+getpostrn3);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logoutB:
                Intent i6 = new Intent(this, Register.class);
                startActivity(i6);
                break;

            case R.id.newtopicB:

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.message, null);
                final EditText msubject = (EditText) mView.findViewById(R.id.subjecttxt);
                final EditText messageT = (EditText) mView.findViewById(R.id.messagetxt);
                Button bpost = (Button) mView.findViewById(R.id.postB);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                bpost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(loggedinuser.equals("tom")) {
                            if (!msubject.getText().toString().isEmpty() && !messageT.getText().toString().isEmpty()) {
                                Toast.makeText(Forum.this, "Sucessefuly Posted Message: " + msubject.getText().toString(), Toast.LENGTH_SHORT).show();

                                myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                myeditor = myPrefs.edit();
                                String getname = myPrefs.getString("nameStr", "0");
                                // String postid = myPrefs.getString(getname, "0");
                                myeditor.putString("from1postdet", "From: " + loggedinuser + "\nSubject: " +msubject.getText().toString() + "\n Message: " + "\n"+messageT.getText().toString());
                                myeditor.commit();
                                String getpost1 = myPrefs.getString("from1postdet", "0");
                                postid1.setText(getpost1);

                                dialog.dismiss();


                            } else {
                                Toast.makeText(Forum.this, "Subject/Message not entered!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(loggedinuser.equals("tim")){
                            if (!msubject.getText().toString().isEmpty() && !messageT.getText().toString().isEmpty()) {
                                Toast.makeText(Forum.this, "Sucessefuly Posted Message: " + msubject.getText().toString(), Toast.LENGTH_SHORT).show();

                                myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                myeditor = myPrefs.edit();
                                String getname = myPrefs.getString("nameStr", "0");
                                // String postid = myPrefs.getString(getname, "0");
                                myeditor.putString("from2postdet", "From: " + loggedinuser + "\nSubject: " +msubject.getText().toString() + "\n Message: " + "\n"+ messageT.getText().toString());
                                myeditor.commit();
                                String getpost2 = myPrefs.getString("from2postdet", "0");
                                postid2.setText(getpost2);

                                dialog.dismiss();


                            } else {
                                Toast.makeText(Forum.this, "Subject/Message not entered!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if(loggedinuser.equals("john")){
                            if (!msubject.getText().toString().isEmpty() && !messageT.getText().toString().isEmpty()) {
                                Toast.makeText(Forum.this, "Sucessefuly Posted Message: " + msubject.getText().toString(), Toast.LENGTH_SHORT).show();

                                myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                                myeditor = myPrefs.edit();
                                String getname = myPrefs.getString("nameStr", "0");
                                // String postid = myPrefs.getString(getname, "0");
                                myeditor.putString("from3postdet", "From: " + loggedinuser + "\nSubject: " +msubject.getText().toString() + "\n Message: " + "\n"+messageT.getText().toString());
                                myeditor.commit();
                                String getpost3 = myPrefs.getString("from3postdet", "0");
                                postid3.setText(getpost3);

                                dialog.dismiss();


                            } else {
                                Toast.makeText(Forum.this, "Subject/Message not entered!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                Button discb = (Button) mView.findViewById(R.id.discardB);
                discb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            break;
            case R.id.reply1:

                mBuilder = new AlertDialog.Builder(this);
                View mView2 = getLayoutInflater().inflate(R.layout.reply, null);
                final EditText reptxt = (EditText) mView2.findViewById(R.id.reptxt);
                Button postb = (Button) mView2.findViewById(R.id.postB);

                mBuilder.setView(mView2);
                final AlertDialog dialog2 = mBuilder.create();
                dialog2.show();

                postb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            Toast.makeText(Forum.this, "Sucessefuly Posted Reply", Toast.LENGTH_SHORT).show();

                            String getop = myPrefs.getString("from1postdet", "0");
                            myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                            myeditor = myPrefs.edit();
                            String getreply = myPrefs.getString("thread1det", "");
                            String nonappendedreply = "From: " + loggedinuser + "\n Message: " +"\n"+ reptxt.getText().toString();
                            myeditor.putString("thread1det", nonappendedreply);
                             myeditor.commit();
                            String appendedreply = getreply+"\n----------------------------------------\n From: " + loggedinuser + "\n Message: " +"\n"+ reptxt.getText().toString()+"\n\n\n";
                            myeditor.putString("thread1det", appendedreply);
                            myeditor.commit();

                        dialog2.dismiss();
                    }
                });
                Button cancelb = (Button) mView2.findViewById(R.id.discardB);
                cancelb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
                break;

            case R.id.thread1:
               // setContentView(R.layout.thread_dialog);
                /*
                Thread_dialog thrd = new Thread_dialog(Forum.this);
                thrd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                thrd.show();
                */
              //  RelativeLayout rlthrd = (RelativeLayout) findViewById(R.id.rlforum);

               // String getop = myPrefs.getString("from1postdet", "0");
                //String replytostr = getop.substring(getop.lastIndexOf("From: ") + 1);
             //   String arr[] = getop.split(" ", 3);
             //   String replytostr = arr[1];
                //String replytostr=getop.substring(2);

                myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
               // myeditor = myPrefs.edit();
              //  myeditor.putString("thread1det", "Replied to: "+replytostr+"\n From: " + loggedinuser + "\n Message: " + reptxt.getText().toString());
               // myeditor.commit();
                String getrep1 = myPrefs.getString("thread1det", "0");


                TextView threadrep1 = new TextView(getApplicationContext());
                //  threadrep1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

                RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(600,500 );
                threadrep1.setLayoutParams(lp2);
                threadrep1.setText(getrep1);
                threadrep1.setTextColor(Color.parseColor("#fbef1b1b"));

                myeditor = myPrefs.edit();
                String sendthreadid1 = myPrefs.getString("threadid1", "0");
                myeditor.putString("threadid", "threadid1");
                String senduser1 = myPrefs.getString("senduser", "0");
                myeditor.putString("senduser", "tom");
                myeditor.commit();

                startActivity(new Intent(Forum.this, Thread_dialog.class));


            break;

            case R.id.reply2:

                mBuilder = new AlertDialog.Builder(this);
                View mView3 = getLayoutInflater().inflate(R.layout.reply, null);
                final EditText reptxt2 = (EditText) mView3.findViewById(R.id.reptxt);
                Button postb2 = (Button) mView3.findViewById(R.id.postB);

                mBuilder.setView(mView3);
                final AlertDialog dialog3 = mBuilder.create();
                dialog3.show();

                postb2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Forum.this, "Sucessefuly Posted Reply", Toast.LENGTH_SHORT).show();

                        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                        myeditor = myPrefs.edit();
                        String getreply2 = myPrefs.getString("thread2det", "");
                        String nonappendedreply2 = "From: " + loggedinuser + "\n Message: " +"\n"+ reptxt2.getText().toString();
                        myeditor.putString("thread2det", nonappendedreply2);
                        myeditor.commit();
                        String appendedreply2 = getreply2+"\n----------------------------------------\n From: " + loggedinuser + "\n Message: " +"\n"+ reptxt2.getText().toString()+"\n\n\n\n";
                        myeditor.putString("thread2det", appendedreply2);
                        myeditor.commit();

                        dialog3.dismiss();
                    }
                });
                Button cancelb2 = (Button) mView3.findViewById(R.id.discardB);
                cancelb2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog3.dismiss();
                    }
                });
                break;

            case R.id.thread2:

                myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

                String getrep2 = myPrefs.getString("thread2det", "");


                TextView threadrep2 = new TextView(getApplicationContext());

                RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(740,1000 );
                threadrep2.setLayoutParams(lp3);
                threadrep2.setText(getrep2);
                threadrep2.setTextColor(Color.parseColor("#fbef1b1b"));

                myeditor = myPrefs.edit();
                String sendthreadid2 = myPrefs.getString("threadid", "0");
                myeditor.putString("threadid", "threadid2");
                String senduser2 = myPrefs.getString("senduser", "");
                myeditor.putString("senduser", "tim");
                myeditor.commit();


                startActivity(new Intent(Forum.this, Thread_dialog.class));


                break;

            case R.id.reply3:

                mBuilder = new AlertDialog.Builder(this);
                View mView4 = getLayoutInflater().inflate(R.layout.reply, null);
                final EditText reptxt3 = (EditText) mView4.findViewById(R.id.reptxt);
                Button postb3 = (Button) mView4.findViewById(R.id.postB);

                mBuilder.setView(mView4);
                final AlertDialog dialog4 = mBuilder.create();
                dialog4.show();
                myeditor = myPrefs.edit();

                postb3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Forum.this, "Sucessefuly Posted Reply", Toast.LENGTH_SHORT).show();

                       // String getop3 = myPrefs.getString("from3postdet", "0");
                      //  String arr2[] = getop3.split(" ", 3);
                      //  String replytostr = arr2[1];
                        myPrefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                        myeditor = myPrefs.edit();
                        String getreply2 = myPrefs.getString("thread3det", "");
                        String nonappendedreply2 = "From: " + loggedinuser + "\n Message: " +"\n"+ reptxt3.getText().toString();
                        myeditor.putString("thread3det", nonappendedreply2);
                        myeditor.commit();
                        String appendedreply2 = getreply2+"\n----------------------------------------\n From: " + loggedinuser + "\n Message: " +"\n"+ reptxt3.getText().toString()+"\n\n\n";
                        myeditor.putString("thread3det", appendedreply2);
                        myeditor.commit();

                        dialog4.dismiss();
                    }
                });
                Button cancelb3 = (Button) mView4.findViewById(R.id.discardB);
                cancelb3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog4.dismiss();
                    }
                });
                break;

            case R.id.thread3:

                myeditor = myPrefs.edit();
                String sendthreadid3 = myPrefs.getString("threadid", "0");
                myeditor.putString("threadid", "threadid3");
                String senduser3 = myPrefs.getString("senduser", "");
                myeditor.putString("senduser", "john");
                myeditor.commit();

                startActivity(new Intent(Forum.this, Thread_dialog.class));


                break;

            case R.id.cleardiscB:
                myeditor.remove("thread1det");
                myeditor.remove("thread2det");
                myeditor.remove("thread3det");
                myeditor.apply();
            break;
            default:
                break;
        }
    }
}
