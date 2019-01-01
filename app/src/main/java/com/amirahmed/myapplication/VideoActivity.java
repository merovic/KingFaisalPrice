package com.amirahmed.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoview);

        MediaController mediaController = new MediaController(this);
        videoView.setVideoURI(Uri.parse(getIntent().getStringExtra("video")));
        videoView.requestFocus();
        videoView.start();
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.seekTo(100);
    }
}
