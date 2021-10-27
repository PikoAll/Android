package com.example.ciclodivitaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bottone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottone=findViewById(R.id.button);

        bottone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //startIntend();  alternativa
                Intent intent=SecondActivity.getIntent(MainActivity.this, "Passaggio parametro");
                startActivity(intent);
            }
        });



    }

    /*
    private void startIntend(){
        Intent intent=new Intent(this,SecondActivity.class);    //cosi andiamo nella seconda activity
        intent.putExtra("key_value",5);  //passaggio di parametro
        startActivity(intent);
    }
    */


    /**
     * questi metodi qua giu sono utili per vedere se l'app e in becgraund....
     * e in tal caso per esempio se la'pp va in becground chiudere determinate cose per far risparmiare batteria es chiudere la geocalizazione
     */
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Sotop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("SDistrutto");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Pausa");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ripresa");
    }
}