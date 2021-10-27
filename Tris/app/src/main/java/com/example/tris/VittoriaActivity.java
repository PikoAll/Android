package com.example.tris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VittoriaActivity extends AppCompatActivity {

    private static final String TAG=VittoriaActivity.class.getSimpleName();
    private static final String POINT_KEY =TAG+"point.key" ;

    private TextView testo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vittoria);

        testo=findViewById(R.id.TestoVittoria);

        String s=getIntent().getStringExtra(POINT_KEY);

        testo.setText("HA VINTO '"+s+"'");


    }

    public static Intent getIstanceIntent(Context context, String s){
        Intent intent=new Intent(context,VittoriaActivity.class);
        intent.putExtra(POINT_KEY,s);
        return intent;
    }

}