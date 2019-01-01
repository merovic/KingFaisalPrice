package com.amirahmed.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import im.delight.android.webview.AdvancedWebView;

public class Web2Activity extends AppCompatActivity implements AdvancedWebView.Listener{

    private AdvancedWebView mWebView;

    ImageView image,file,video,share;

    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);

        tinyDB = new TinyDB(this);

        mWebView = findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.loadUrl(getIntent().getStringExtra("url"));
        mWebView.zoomOut();
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);


        image = findViewById(R.id.image);
        file = findViewById(R.id.file);
        video = findViewById(R.id.video);
        share = findViewById(R.id.share);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final FragmentManager fm = getFragmentManager();
                ImageFragment imageFragment = new ImageFragment();

                tinyDB.putString("image",getIntent().getStringExtra("image"));

                imageFragment.show(fm,"TV_tag");

            }
        });

        file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getStringExtra("file"))));


            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Web2Activity.this,VideoActivity.class);
                intent.putExtra("video",getIntent().getStringExtra("video"));
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(); intent2.setAction(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra("url"));
                startActivity(Intent.createChooser(intent2, "Share via"));
            }
        });


        haveStoragePermission();

    }


    public boolean haveStoragePermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.e("Permission error","You have permission");
                return true;
            } else {

                Log.e("Permission error","You have asked for permission");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //you dont need to worry about these stuff below api level 23
            Log.e("Permission error","You already have the permission");
            return true;
        }
    }

    @Override
    public void onBackPressed() {

        if(mWebView.canGoBack())
        {
            mWebView.onBackPressed();
        }else
        {
            super.onBackPressed();

        }

    }

    @SuppressLint("NewApi")
    @Override
    public void onResume() {
        super.onResume();
        mWebView.onResume();

    }

    @SuppressLint("NewApi")
    @Override
    public void onPause() {
        mWebView.onPause();

        super.onPause();
    }

    @Override
    public void onDestroy() {
        mWebView.onDestroy();

        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
    }


    @Override
    public void onPageStarted(String url, Bitmap favicon) {

        mWebView.zoomOut();
        //view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(String url) {

        mWebView.zoomOut();
        //view.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

        mWebView.zoomOut();
    }

    @Override
    public void onExternalPageRequest(String url) {

    }
}