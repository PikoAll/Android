package com.example.video;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path="C:\\Users\\peppi\\Desktop\\Android\\Video\\app\\src\\main\\res\\video\\video.mp4";

        videoView.findViewById(R.id.videoView);
        videoView.setVideoPath(path);
        videoView.start();

    }
}