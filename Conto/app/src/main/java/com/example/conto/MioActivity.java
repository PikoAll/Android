package com.example.conto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MioActivity extends AppCompatActivity {

    private EditText soldi,casuale;
    private TextView totale,titolo;
    private GestioneDB db = new GestioneDB(this);

    private DatabaseBanca dbB = new DatabaseBanca(this);
    private boolean fl=false;

    private static final String TAG=RisultatoActivity.class.getName();
    private static final String KEY_value=TAG+".extras.value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mio);

        soldi = findViewById(R.id.soldi);
        casuale = findViewById(R.id.casuale);
        totale = findViewById(R.id.totale);
        titolo = findViewById(R.id.titolo);

        String verifica = getIntent().getStringExtra(KEY_value);
        fl = false;
        if(verifica.equals("Banca")){
            fl=true;
            titolo.setText("BANCA");
        }else{
            titolo.setText("MIO");
        }
        System.out.println("############################################MIOOOOO"+fl);

        totale();


    }
    public static Intent getIstanceIntent(Context context,String s){
        Intent intent=new Intent(context,MioActivity.class);
        intent.putExtra(KEY_value,s);
        return intent;
    }

    public void clickBottone(View v){

        String s = "";
        if( fl== true){
            s="Banca";
        }
        int id = v.getId();

        if (id == R.id.sottrai){

            String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

            if (soldi.getText().toString().equals("") || casuale.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Campo mancante",Toast.LENGTH_SHORT).show();
            }else{
                if(casuale.getText().length()>45){
                    Toast.makeText(getApplicationContext(),"Casuale troppo lungha",Toast.LENGTH_SHORT).show();
                    pulisci();
                }else{
                    scriviDB("-"+soldi.getText().toString(),casuale.getText().toString(),timeStamp.toString());
                    totale();
                    pulisci();
                }
            }




        }else if(id == R.id.somma){
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

            if (soldi.getText().toString().equals("") || casuale.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Campo mancante",Toast.LENGTH_SHORT).show();
            }else{
                if(casuale.getText().length()>35){
                    Toast.makeText(getApplicationContext(),"Casuale troppo lungha",Toast.LENGTH_SHORT).show();
                    pulisci();
                }else{
                    scriviDB("+"+soldi.getText().toString(),casuale.getText().toString(),timeStamp.toString());
                    totale();
                    pulisci();
                }
            }


        }else if(id == R.id.saldo){

            totale();
            pulisci();

        }else if(id == R.id.statistica){
            Intent intent=RisultatoActivity.getIntent(this,"statistica",s);
            startActivity(intent);
        }else if(id == R.id.listaMov){
            Intent intent=RisultatoActivity.getIntent(this,"lista",s);
            startActivity(intent);
        }

    }


    private void scriviDB(String soldi, String casuale, String data){
        if(fl == false){
            db.open();
            long id = db.inserisciCliente(soldi,casuale,data);
            db.close();
        }else{
            dbB.open();
            long id = dbB.inserisciCliente(soldi,casuale,data);
            dbB.close();
        }


    }

    private void leggiDB(){
        Cursor c;
        if ( fl == false){
            db.open();
             c = db.ottieniTutto();
        }else{
            dbB.open();
            c = dbB.ottieniTutto();
        }

        float prova=0;
        if (c.moveToFirst()) {
            do {
                Toast.makeText(this, "id: " + c.getString(0) + "\n" +
                                "Nome: " + c.getString(1) + "\n" +
                                "Indirizzo: " + c.getString(2),
                        Toast.LENGTH_LONG).show();
                prova=prova+c.getFloat(1);
                System.out.println("id: " + c.getString(0) + "\n" +
                        "soldi: " + c.getString(1) + "\n" +
                        "Casuale: " + c.getString(2)+" data"+c.getString(3));
            } while (c.moveToNext());
        }
        if (fl == false){
            db.close();
        }else{
            dbB.close();
        }
        //System.out.println("-------------------------------------------------------"+ prova);
        totale();
    }

    private void totale(){
        Cursor c;
        if(fl == false){
            db.open();
            c = db.ottieniTutto();
        }else {
            dbB.open();
            c = dbB.ottieniTutto();
        }

        float prova=0;
        if (c.moveToFirst()) {
            do {

                prova = prova+c.getFloat(1);

            } while (c.moveToNext());
        }
        if (fl == false){
            db.close();
        }else{
            dbB.close();
        }
        totale.setText(String.valueOf(prova));
    }

    private void pulisci(){
        soldi.setText("");
        casuale.setText("");
    }


}