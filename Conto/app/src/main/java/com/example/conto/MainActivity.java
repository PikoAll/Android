package com.example.conto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBottone(View v){

        int id = v.getId();

        if (id == R.id.conto){

            Intent intent=ContoActivity.getIstanceIntent(MainActivity.this);
            startActivity(intent);

        }else if(id == R.id.ricordami){
            Toast.makeText(getApplicationContext(),"Ricordami",Toast.LENGTH_SHORT).show();

        }else if(id == R.id.spesa){

            Intent intent=SpesaActivity.getIstanceIntent(MainActivity.this);
            startActivity(intent);

        }

    }

}