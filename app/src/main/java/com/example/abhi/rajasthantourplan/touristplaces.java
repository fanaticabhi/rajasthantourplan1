package com.example.abhi.rajasthantourplan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class touristplaces extends AppCompatActivity {
    Spinner s1;
    static  String data[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touristplaces);


        s1=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> arr=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,data);
        s1.setAdapter(arr);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





















    }


     public void cityselection() {
        StringRequest st = new StringRequest(Request.Method.POST,
                "http://www.rajasthantourplan.esy.es/phpfiles/retrievecity.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                getStatus(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String,String> getParams() {
                Map<String, String> mp = new HashMap<String, String>();
              //  mp.put("city",city.getText().toString());
                return mp;
            }
        };
        RequestQueue q = Volley.newRequestQueue(touristplaces.this);
        q.add(st);
    }



    public void getStatus(String stt) {
        try {
            JSONObject obj = new JSONObject(stt);
            while(obj)
            String res[] = obj.getString("city");
                data=res;
                Toast.makeText(touristplaces.this, "Search Successful", Toast.LENGTH_SHORT).show();
       } catch(Exception e) {
            Toast.makeText(touristplaces.this, "Error"+e, Toast.LENGTH_SHORT).show();
        }
    }
}
