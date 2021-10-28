package com.example.conto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class RisultatoActivity extends AppCompatActivity {

    private GestioneDB db = new GestioneDB(this);
    private DatabaseBanca dbB = new DatabaseBanca(this);
    private TextView rsoldi,rcasuale,rdata;

    private static final String TAG=RisultatoActivity.class.getName();
    private static final String KEY_value=TAG+".extras.value";
    private static final String KEY_valueB=TAG+".b.value";

    private boolean fl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risultato);
        //risultato = findViewById(R.id.risultato);
        rsoldi = findViewById(R.id.rsoldi);
        rcasuale = findViewById(R.id.rcasuale);
        rdata = findViewById(R.id.rdata);

        String verifica = getIntent().getStringExtra(KEY_value);
        String verificaB = getIntent().getStringExtra(KEY_valueB);

        if(verificaB.equals("Banca")){
            fl = true;
        }

        if(verifica.equals("lista")){
            totale();
        }else if(verifica.equals("statistica")){

            statistica();


        }


    }

    public static Intent getIntent(Context context,String s,String ss){
        Intent intent=new Intent(context,RisultatoActivity.class);
        intent.putExtra(KEY_value,s);
        intent.putExtra(KEY_valueB,ss);
        return intent;

    }

    private void totale(){
        Cursor c;
        if( fl == false){
            db.open();
            c = db.ottieniTutto();
        }else{
            dbB.open();
            c = dbB.ottieniTutto();
        }

        String s1 = "   Soldi\n\n";
        String s2 = "Casuale\n\n";
        String s3 = "Data\n\n";
        if (c.moveToLast()) {
            do {


                s1 = s1 + "     " + String.valueOf(c.getFloat(1))+"\n\n";
                s2 = s2 + c.getString(2)+"\n\n";
                s3 = s3 + c.getString(3)+"\n\n";



            } while (c.moveToPrevious());
        }
        if (fl == false){
            db.close();
        }else{
            dbB.close();
        }
        rsoldi.setText(s1);
        rcasuale.setText(s2);
        rdata.setText(s3);
        //risultato.setText(s);
    }

    private void statistica(){
        Map<String,String> dizionario = new HashMap<String,String>();
        Cursor c;
        if(fl == false){
            db.open();
             c = db.ottieniTutto();
        }else{
            dbB.open();
            c = dbB.ottieniTutto();
        }

        String key,value;
        if (c.moveToLast()) {
            do {

                if (c.getFloat(1)<=0){
                    key = c.getString(2);

                    if(dizionario.get(key)==null){
                        dizionario.put(key,String.valueOf(c.getFloat(1)));
                    }else{
                        String x = dizionario.get(key).toString();
                        float y= Float.parseFloat(x);
                        dizionario.put(key,String.valueOf(c.getFloat(1)+y));

                    }
                }



            } while (c.moveToPrevious());
        }
        if (fl == false){
            db.close();
        }else{
            dbB.close();
        }

        String s1="Casuale\n\n",s2="Soldi\n\n";
        for (String key1: dizionario.keySet()){
            s1 = s1 + key1 + "\n\n";
            s2 = s2 + dizionario.get(key1) + "\n\n";
        //    System.out.println(key1+ " = " + dizionario.get(key1));
        //    System.out.println("------------------------");
        }
        rsoldi.setText(s2);
        rcasuale.setText(s1);
        rdata.setText("");


    }
}