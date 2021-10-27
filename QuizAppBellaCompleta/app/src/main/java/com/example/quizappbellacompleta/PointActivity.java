package com.example.quizappbellacompleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {

    private static final String TAG=PointActivity.class.getSimpleName();
    private static final String POINT_KEY =TAG+"point.key" ;
    private static final String POINT_TOTAL_KEY = TAG+"point.total.key";

    private TextView risultato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        risultato=findViewById(R.id.risultato);
        int punteggio=getIntent().getIntExtra(POINT_KEY,0); //0 valore default
        int punteggioTott=getIntent().getIntExtra(POINT_TOTAL_KEY,0); //0 valore default

        risultato.setText("hai fatto "+String.valueOf(punteggio)+" su "+String.valueOf(punteggioTott));
    }

    public static Intent getIstanceIntent(Context context,int point, int point_total){
        Intent intent=new Intent(context,PointActivity.class);
        intent.putExtra(POINT_KEY,point);
        intent.putExtra(POINT_TOTAL_KEY,point_total);
        return intent;
    }

}