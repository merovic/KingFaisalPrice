package com.amirahmed.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class WinnersActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    List<String> data1 = new ArrayList<>();
    List<String> data2 = new ArrayList<>();
    List<String> data3 = new ArrayList<>();

    ArrayAdapter<String> adapter,adapter2;
    ArrayAdapter<String> adapter3;

    Spinner spinner1,spinner2,spinner3;

    Button button;

    EditText search;

    WinnerRootClass[] winnerRootClasses;

    ImageView face,twitter,insta,linked,youtube,share;

    ImageView imageView;

    Ln ln;

    TinyDB tinyDB;

    String c_image,c_video,c_url,c_file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);

        tinyDB = new TinyDB(this);

        ln = new Ln(tinyDB.getBoolean("Language"));

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);

        face = findViewById(R.id.face);
        twitter = findViewById(R.id.twitter);
        insta = findViewById(R.id.insta);
        linked = findViewById(R.id.linked);
        youtube = findViewById(R.id.youtube);
        share = findViewById(R.id.share);

        imageView = findViewById(R.id.image);

        search = findViewById(R.id.search);

        search.setHint(ln.getSearch());

        Glide.with(getApplicationContext())
                .asGif()
                .load(R.drawable.logoprize)
                .into(imageView);

        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinnersActivity.this,WebActivity.class);
                intent.putExtra("url","https://www.facebook.com/KingFaisalPrize/");
                startActivity(intent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinnersActivity.this,WebActivity.class);
                intent.putExtra("url","https://www.instagram.com/kingfaisalprize/");
                startActivity(intent);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinnersActivity.this,WebActivity.class);
                intent.putExtra("url","https://twitter.com/KingFaisalPrize");
                startActivity(intent);
            }
        });

        linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinnersActivity.this,WebActivity.class);
                intent.putExtra("url","https://www.linkedin.com/company/king-faisal-international-prize");
                startActivity(intent);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WinnersActivity.this,WebActivity.class);
                intent.putExtra("url","https://www.youtube.com/user/KFIP1");
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/KingFaisalPrize/");
                startActivity(Intent.createChooser(intent2, "Share via"));
            }
        });


        search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press

                    Intent intent = new Intent(WinnersActivity.this,WinnersListActivity.class);
                    intent.putExtra("search",search.getText().toString());
                    startActivity(intent);

                    return true;
                }
                return false;
            }
        });



        button = findViewById(R.id.button);

        button.setText(ln.getEnter());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(spinner3.getSelectedItemPosition() == 0)
                {
                    Toast.makeText(WinnersActivity.this,ln.getChoose(),Toast.LENGTH_SHORT).show();
                }else
                    {
                        Intent intent = new Intent(WinnersActivity.this,Web2Activity.class);
                        intent.putExtra("url",c_url);
                        intent.putExtra("image", c_image);
                        intent.putExtra("file",c_file);
                        intent.putExtra("video",c_video);
                        startActivity(intent);
                    }

            }
        });

        for(int i = 1979;i<2026;i++)
        {
            data1.add(String.valueOf(i));
        }

        data2.add(ln.getScience());
        data2.add(ln.getEslam());
        data2.add(ln.getStudies());
        data2.add(ln.getArabic());
        data2.add(ln.getMedical());

        adapter = new ArrayAdapter<>(this, R.layout.spinner_item, data1);
        adapter2 = new ArrayAdapter<>(this, R.layout.spinner_item, data2);
        adapter3 = new ArrayAdapter<>(this, R.layout.spinner_item, data3);

        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        adapter.notifyDataSetChanged();

        adapter2.setDropDownViewResource(R.layout.spinner_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        adapter2.notifyDataSetChanged();

        adapter3.setDropDownViewResource(R.layout.spinner_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        adapter3.notifyDataSetChanged();
    }


    public void JSON_DATA_WEB_CALL3(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://technowow.net/webservice_prize.asmx/select_all_prize_winer_by_year_type",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();

                        winnerRootClasses = gson.fromJson(response, WinnerRootClass[].class);

                        data3.clear();

                        data3.add(ln.getChoose());

                        for (WinnerRootClass winnerRootClass : winnerRootClasses) {
                            data3.add(winnerRootClass.getName());

                        }

                        adapter3.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("year", spinner1.getSelectedItem().toString());
                params.put("type", spinner2.getSelectedItem().toString());
                return params;
            }

        };

        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.spinner1)
        {

            JSON_DATA_WEB_CALL3();
            spinner2.setSelection(0);
            spinner3.setSelection(0);


        }else if(parent.getId() == R.id.spinner2)
        {

            JSON_DATA_WEB_CALL3();
            spinner3.setSelection(0);

        }else
            {
                if(position!=0)
                {

                    c_url = winnerRootClasses[position-1].getUrl();
                    c_image = "https://www.kingfaisalappstore.org/" +  winnerRootClasses[position-1].getCertif();
                    c_file = "https://www.kingfaisalappstore.org/" + winnerRootClasses[position-1].getFile();
                    c_video = "https://www.kingfaisalappstore.org/" + winnerRootClasses[position-1].getVideo();
                }

            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
