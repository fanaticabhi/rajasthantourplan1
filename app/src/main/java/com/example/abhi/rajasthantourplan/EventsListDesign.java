package com.example.abhi.rajasthantourplan;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsListDesign extends BaseAdapter {

    ArrayList<String>title = new ArrayList<String>();
    ArrayList<String>desc = new ArrayList<String>();
    ArrayList<String>start = new ArrayList<String>();
    ArrayList<String>end = new ArrayList<String>();
    ArrayList<String>ctgry = new ArrayList<String>();
    Context ct;
    LayoutInflater lttt;
    public EventsListDesign(Context cnt, ArrayList<String>ttl, ArrayList<String>dsc, ArrayList<String>start, ArrayList<String>end, ArrayList<String>cat){
        this.title = ttl;
        this.desc = dsc;
        this.start = start;
        this.end = end;
        this.ctgry = cat;
        ct = cnt;
        lttt = LayoutInflater.from(ct);
    }
    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return title.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = lttt.inflate(R.layout.activity_events_list_design, null);
        TextView t1, t2, t3, t4, t5;
        t1 = convertView.findViewById(R.id.textView2);
        t2 = convertView.findViewById(R.id.textView3);
        t3 = convertView.findViewById(R.id.textView5);
        t4 = convertView.findViewById(R.id.textView7);
        t5 = convertView.findViewById(R.id.textView10);
        t1.setText(title.get(position));
        t2.setText(desc.get(position));
        t3.setText(start.get(position));
        t4.setText(end.get(position));
        t5.setText(ctgry.get(position));
        return convertView;
    }
}