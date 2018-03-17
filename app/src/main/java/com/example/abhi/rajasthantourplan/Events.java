package com.example.abhi.rajasthantourplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Events extends AppCompatActivity {

    ListView lt;
    ArrayList<String> ttl, dsc, start, end, cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        lt = findViewById(R.id.events);
        ttl = new ArrayList<String>();
        dsc = new ArrayList<String>();
        start = new ArrayList<String>();
        end = new ArrayList<String>();
        cat = new ArrayList<String>();

        //Code to add data to the dynamic list.

        EventsListDesign e = new EventsListDesign(getApplicationContext(), ttl, dsc, start, end, cat);
        lt.setAdapter(e);
    }
}
