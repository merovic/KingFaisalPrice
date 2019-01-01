package com.amirahmed.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import im.delight.android.webview.AdvancedWebView;

public class WebActivity extends AppCompatActivity implements AdvancedWebView.Listener{

    private AdvancedWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mWebView = findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.loadUrl(getIntent().getStringExtra("url"));
        mWebView.zoomOut();
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);

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