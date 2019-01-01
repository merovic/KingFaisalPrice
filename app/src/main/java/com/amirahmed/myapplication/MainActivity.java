package com.amirahmed.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    List<String> data1 = new ArrayList<>();
    List<String> data2 = new ArrayList<>();

    ArrayAdapter<String> adapter,adapter2;

    Spinner spinner1,spinner2;

    Button button;

    String selectedURL;

    int selectedPosition;

    ImageView imageView,language;

    ImageView face,twitter,insta,linked,youtube,share;

    Ln ln;

    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tinyDB = new TinyDB(this);

        //tinyDB.putBoolean("Language",true);

        ln = new Ln(tinyDB.getBoolean("Language"));

        language = findViewById(R.id.language);

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tinyDB.getBoolean("Language"))
                {
                    tinyDB.putBoolean("Language",false);
                }else
                    {
                        tinyDB.putBoolean("Language",true);
                    }

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        face = findViewById(R.id.face);
        twitter = findViewById(R.id.twitter);
        insta = findViewById(R.id.insta);
        linked = findViewById(R.id.linked);
        youtube = findViewById(R.id.youtube);
        share = findViewById(R.id.share);

        imageView = findViewById(R.id.image);

        Glide.with(getApplicationContext())
                .asGif()
                .load(R.drawable.logoprize)
                .into(imageView);

        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url","https://www.facebook.com/KingFaisalPrize/");
                startActivity(intent);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url","https://www.instagram.com/kingfaisalprize/");
                startActivity(intent);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url","https://twitter.com/KingFaisalPrize");
                startActivity(intent);
            }
        });

        linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url","https://www.linkedin.com/company/king-faisal-international-prize");
                startActivity(intent);
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WebActivity.class);
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

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        button = findViewById(R.id.button);

        button.setText(ln.getEnter());

        data1.add(ln.getIntroductionWord());
        data1.add(ln.getAngayza());
        data1.add(ln.getCategories());
        data1.add(ln.getNomination());
        data1.add(ln.getWinners());
        data1.add(ln.getContactus());


        selectedURL = ln.getKhaledlink();

        adapter = new ArrayAdapter<>(this, R.layout.spinner_item, data1);

        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        adapter.notifyDataSetChanged();


        spinner2.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,WebActivity.class);
                intent.putExtra("url",selectedURL);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.spinner1)
        {

            data2.clear();

            if(position==0)
            {

                spinner2.setVisibility(View.VISIBLE);

                data2.add(ln.getKhaledword());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url",ln.getKhaledlink());
                        startActivity(intent);
                    }
                });

            }else if(position==1)
            {

                spinner2.setVisibility(View.VISIBLE);

                data2.add(ln.getNabza());
                data2.add(ln.getEnshaa());
                data2.add(ln.getAhdaf());
                data2.add(ln.getAmana());
                data2.add(ln.getTare5());
                data2.add(ln.getMokawnat());
                data2.add(ln.getHay2a());
                data2.add(ln.getMas2olen());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url",ln.getNabzaLink());
                        startActivity(intent);
                    }
                });

            }else if(position==2)
            {
                spinner2.setVisibility(View.VISIBLE);

                data2.add(ln.getScience());
                data2.add(ln.getEslam());
                data2.add(ln.getStudies());
                data2.add(ln.getArabic());
                data2.add(ln.getMedical());


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url",ln.getScienceLink());
                        startActivity(intent);
                    }
                });

            }else if(position==3)
            {

                spinner2.setVisibility(View.VISIBLE);

                data2.add(ln.getScience());
                data2.add(ln.getEslam());
                data2.add(ln.getStudies());
                data2.add(ln.getArabic());
                data2.add(ln.getMedical());

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url",ln.getNominationLink());
                        startActivity(intent);
                    }
                });

            }else if(position==4)
            {

                spinner2.setVisibility(View.GONE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WinnersActivity.class);
                        startActivity(intent);
                    }
                });

            }else if(position==5)
            {

                spinner2.setVisibility(View.GONE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url",ln.getContactus());
                        startActivity(intent);
                    }
                });
            }

            adapter2 = new ArrayAdapter<>(this, R.layout.spinner_item, data2);

            adapter2.setDropDownViewResource(R.layout.spinner_item);
            spinner2.setAdapter(adapter2);

            adapter2.notifyDataSetChanged();

            selectedPosition = position;

        }
        else {

            if(selectedPosition==0)
            {

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url",ln.getKhaledlink());
                        startActivity(intent);
                    }
                });
            }else if(selectedPosition==1)
            {
                if(position==0)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getNabzaLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==1)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getEnshaaLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==2)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getAhdafLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==3)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getAmanaLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==4)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getTare5Link());
                            startActivity(intent);
                        }
                    });
                }else if(position==5)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getMokawnatLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==6)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getHay2aLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==7)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getMas2olenLink());
                            startActivity(intent);
                        }
                    });
                }
            }else if(selectedPosition==2)
            {
                if(position==0)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getScienceLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==1)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getEslamLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==2)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getArabicLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==3)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getStudiesLink());
                            startActivity(intent);
                        }
                    });
                }else if(position==4)
                {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(MainActivity.this,WebActivity.class);
                            intent.putExtra("url",ln.getMedicalLink());
                            startActivity(intent);
                        }
                    });
                }
            }else if(selectedPosition==3)
            {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url",ln.getNominationLink());
                        startActivity(intent);
                    }
                });
            }

            parent.getId();
        }
    }

    @Override
    public void onBackPressed() {

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
