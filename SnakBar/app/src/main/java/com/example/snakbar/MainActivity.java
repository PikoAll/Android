package com.example.snakbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton floatingActionButton;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton=findViewById(R.id.floatingActionButton);

    }


    public void clickBottone(View v){

        int id=v.getId();

        if(id==R.id.floatingActionButton){

            snackbar=Snackbar.make(v,"messaggio inviato",Snackbar.LENGTH_INDEFINITE);
            snackbar.setDuration(8000);     //setta durata messaggio popUp
            snackbar.setAction("nascondi", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });

            snackbar.show();

        }

    }

}