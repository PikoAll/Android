package com.example.conto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ContoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conto);
    }

    public static Intent getIstanceIntent(Context context){
        Intent intent=new Intent(context,ContoActivity.class);

        return intent;
    }

    public void clickBottone(View v){

        int id = v.getId();

        if (id == R.id.mio){

            Intent intent=MioActivity.getIstanceIntent(ContoActivity.this,"");
            startActivity(intent);

        }else if(id == R.id.banca){
            Intent intent=MioActivity.getIstanceIntent(ContoActivity.this,"Banca");
            startActivity(intent);
        }

    }

}