package com.example.mpe.vulnapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CustomerDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_details);
        TextView cust_detstring = (TextView) findViewById(R.id.cust_detstring);
        String custdetails = "Customer ID: 34562 \n" + "Device ID: 62E4R5";
        cust_detstring.setText(custdetails);

    }
}
