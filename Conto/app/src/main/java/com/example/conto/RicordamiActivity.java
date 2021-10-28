package com.example.conto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RicordamiActivity extends AppCompatActivity {

    private TextView testo,data,cosa;
    private Button buttonR;
    private EditText data22;
    private List<Integer> listaIndici;
    private List<Integer> posEliminare;
    private List<String> listaRi;

    private DatabaseRicorda db = new DatabaseRicorda(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricordami);

        buttonR = findViewById(R.id.buttonR);
        testo = findViewById(R.id.testo);
        data = findViewById(R.id.data);
        cosa = findViewById(R.id.cosa);

        data22 = findViewById(R.id.data22);
        listaIndici = new ArrayList<>();
        listaRi = new ArrayList<>();
        posEliminare = new ArrayList<>();

        visualizza();

    }

    public static Intent getIstanceIntent(Context context){
        Intent intent=new Intent(context,RicordamiActivity.class);
        return intent;
    }


    public void clickR(View v){

        if (testo.getText().equals("") && data22.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Scrivi qualcosa",Toast.LENGTH_SHORT).show();
        }else{
            scriviDB();
        }

    }

    public void scriviDB(){

        //String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

        db.open();
        db.inserisciCliente(testo.getText().toString(),data22.getText().toString());
        db.close();

        data22.setText("");
        testo.setText("");
        visualizza();

    }

    public  void visualizza(){

        Cursor c;

            db.open();
            c = db.ottieniTutto();

        String ricordoS="Ricorda\n\n";
        String dataS="Data\n\n";

        if (c.moveToFirst()) {
            do {
                /*
                Toast.makeText(this, "id: " + c.getString(0) + "\n" +
                                "Nome: " + c.getString(1) + "\n" +
                                "Indirizzo: " + c.getString(2),
                        Toast.LENGTH_LONG).show();

                 */

                ricordoS = ricordoS + c.getString(1)+"\n\n";
                dataS = dataS + c.getString(2)+"\n\n";
                //convertiStringaData(c.getString(2));
                listaIndici.add(c.getInt(0));
                listaRi.add(c.getString(2));
                convertiStringaData(c.getString(2));


            } while (c.moveToNext());
        }

            db.close();
        data.setText(dataS);
        cosa.setText(ricordoS);


        /*
        System.out.println("lista date"+listaRi.toString());
        System.out.println("lista indici"+listaIndici.toString());
        int x = listaRi.indexOf("22/07/95");
        System.out.println(listaIndici.get(x));

         */






    }

    private void convertiStringaData(String date_time){
        //String date_time = "11/27/2020 05:35:00";
        String oggi = new SimpleDateFormat("dd/MM/yy").format(Calendar.getInstance().getTime());
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yy");

            try {
                Date dateE = dateParser.parse(date_time);
                Date dataOggi = dateParser.parse(oggi);
                //System.out.println("2222222222222222222222222222##"+dateE.toString());
                //System.out.println("@@@@@@@@@@@@@@"+differenza(dateE,dataOggi));

                //System.out.println("lista date"+listaRi.toString());
                //System.out.println("lista indici"+listaIndici.toString());


                if (differenza(dateE,dataOggi) < 0){
                    Toast.makeText(this, "data passata",Toast.LENGTH_LONG).show();

                    int idDb = listaRi.indexOf(date_time);
                    //System.out.println("lista date"+listaRi.toString());
                    //System.out.println("lista indici"+listaIndici.toString());
                    db.open();
                    int x = listaIndici.get(idDb);
                    //System.out.println("++++++++++++++++++"+x);
                    db.cancellaCliente(x);
                    // visualizza();
                    db.close();
                }
                /*
                if (differenza(dateE,dataOggi) < 10){
                    Toast.makeText(this, "RICORDO",Toast.LENGTH_LONG).show();
                }

                 */






            } catch (ParseException e) {
                e.printStackTrace();
            }

    }

    private static long differenza(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / 86400000L;
    }



}