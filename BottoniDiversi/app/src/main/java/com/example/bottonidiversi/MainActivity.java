package com.example.bottonidiversi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button bottone1;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottone1=findViewById(R.id.button1);
        floatingActionButton=findViewById(R.id.floatingActionButton2);

    }


    public void clicBottone(View v){

        int id=v.getId();

        if(id==R.id.button1){
            Toast.makeText(getApplicationContext(),"bottone normale",Toast.LENGTH_LONG).show();
        }else if(id==R.id.floatingActionButton2){
            Toast.makeText(getApplicationContext(),"bottone tondo",Toast.LENGTH_LONG).show();
        }

    }

}