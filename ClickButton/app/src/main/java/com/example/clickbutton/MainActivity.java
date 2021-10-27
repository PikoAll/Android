package com.example.clickbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //private Button button;  //il nome della variabile non fa riferimento a l'id


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////
      /*  button=findViewById(R.id.button);  //abbiamo collegato il nostro bottone tramite  id attraverso R.id facciamo riferimento a tutti gli id del file xml
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ciao bottone cliccato");
            }
        });*/
    }

    //oppure se si mette da desine il settagio on click basta fare questo metodo e esso sara public
    public void onClicButton(View v){
        System.out.println("ciao bottone cliccato22");
    }
}