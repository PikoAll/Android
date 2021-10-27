package com.example.immagini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView immagine;
    private int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        immagine=findViewById(R.id.imageView);
        immagine.setImageResource(R.drawable.cane);  //con R sono andato nella cartella contenete le immagini, in questo caso sto settando un'immagine di default

    }


    public void Avanti(View v){
        immagine.setImageResource(R.drawable.pizza);


    }

}