package com.example.conto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseRicorda db = new DatabaseRicorda(this);
    private List<Integer> listaIndici;
    private List<String> listaRi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaIndici = new ArrayList<>();
        listaRi = new ArrayList<>();
        visualizza();


    }

    public void clickBottone(View v){

        int id = v.getId();

        if (id == R.id.conto){

            Intent intent=ContoActivity.getIstanceIntent(MainActivity.this);
            startActivity(intent);

        }else if(id == R.id.ricordami){
            Toast.makeText(getApplicationContext(),"Ricordami",Toast.LENGTH_SHORT).show();
            Intent intent=RicordamiActivity.getIstanceIntent(MainActivity.this);
            startActivity(intent);

        }else if(id == R.id.spesa){

            Intent intent=SpesaActivity.getIstanceIntent(MainActivity.this);
            startActivity(intent);

        }

    }


    public  void visualizza(){

        Cursor c;

        db.open();
        c = db.ottieniTutto();


        if (c.moveToFirst()) {
            do {

                //convertiStringaData(c.getString(2));
                listaIndici.add(c.getInt(0));
                listaRi.add(c.getString(2));
                convertiStringaData(c.getString(2));


            } while (c.moveToNext());
        }

        db.close();







    }


    private void convertiStringaData(String date_time){
        //String date_time = "11/27/2020 05:35:00";
        String oggi = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yy");

        try {
            Date dateE = dateParser.parse(date_time);
            Date dataOggi = dateParser.parse(oggi);


            if (differenza(dateE,dataOggi) < 15){
                Toast.makeText(this, "RICORDO "+date_time,Toast.LENGTH_LONG).show();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static long differenza(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / 86400000L;
    }

}