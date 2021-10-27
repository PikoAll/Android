package com.example.musica2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   // private Button buttonPlay,buttonStop;

    private MediaPlayer mediaPlayer; //e una classe che gestisce l'audio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        buttonPlay=findViewById(R.id.button);
        buttonStop=findViewById(R.id.buttonStop);
*/

       // mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.cazone1);
       /* System.out.println("ciao");

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.cazone1);
                mediaPlayer.start();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });*/

    }

    public  void play(View view){
        mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.cazone1);
            mediaPlayer.start();
    }

    public  void stop(View view){
            mediaPlayer.stop();
    }

}