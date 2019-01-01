package com.amirahmed.myapplication;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WinnersListActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);

        search();
    }


    public void search(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://technowow.net/webservice_prize.asmx/select_all_prize_by_searchname",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        initializeAdapter(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        }) {

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("text_name",getIntent().getStringExtra("search"));
                return params;
            }

        };

        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }


    private void initializeAdapter(String response) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        WinnerRootClass[] winnerRootClasses = gson.fromJson(response, WinnerRootClass[].class);

        List<WinnerRootClass> list = Arrays.asList(winnerRootClasses);

        WinnersAdapter adapter = new WinnersAdapter(list);
        rv.setAdapter(adapter);

        adapter.notifyDataSetChanged();


    }
}
