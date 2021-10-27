package com.example.conto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpesaActivity extends AppCompatActivity {

    private ListView listav;
    private List<String> lista;
    private List<Integer> listaIndici;
    private ArrayAdapter<String> adapter;
    private Switch aSwitch;
    private boolean fl= false;

    private TextView aggiungi;
    private Button conferma;

    private DatabaseSpesa db = new DatabaseSpesa(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spesa);


        aggiungi = findViewById(R.id.aggiungi);

        conferma = findViewById(R.id.conferma);

        listav = findViewById(R.id.listav);
        lista = new ArrayList<>();
        listaIndici = new ArrayList<>();

        aSwitch = findViewById(R.id.switch1);


        inizializzaLista();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista);

        listav.setAdapter(adapter);

        //per rendere cliccabile la lista
        listav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                click(adapterView,view,i,l);
            }
        });


    }

    public static Intent getIstanceIntent(Context context){
        Intent intent=new Intent(context,SpesaActivity.class);

        return intent;
    }

    public void inizializzaLista(){

        /*
        for (int i=0; i<numero; i++){
            lista.add("Persone "+String.valueOf(i));
        }

         */
        lista.clear();
        listaIndici.clear();


        Cursor c;
        db.open();
        c = db.ottieniTutto();



        if (c.moveToFirst()) {
            do {
                lista.add(c.getString(1));
                //System.out.println(c.getInt(0));
                listaIndici.add(c.getInt(0));
            } while (c.moveToNext());
        }

            db.close();


        System.out.println(listaIndici.toString());
        System.out.println(lista.toString());





    }

    public void clickConferma(View v){

        int id = v.getId();

        if(id == R.id.conferma){

            if( aggiungi.getText().toString().equals("")){
                Toast.makeText(this, "Aggiungi qualcosa", Toast.LENGTH_SHORT).show();
            }else{
                sciriDB();
            }


        }



    }

    /*
       per settare e capire il valore della switch
        */
        /*
        aSwitch.setChecked(false);
        System.out.println("9999999999999"+aSwitch.getShowText());

         */
    public  void clickSwitch(View v){

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(aSwitch.isChecked());
            }
        });
    }

    public void click(AdapterView<?> adapterView, View view, int i, long l){
        Toast.makeText(this, "posizione " + i+" nome: "+lista.get(i), Toast.LENGTH_SHORT).show();
        System.out.println(lista.get(i));
        //lista.remove(lista.get(i);

        System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjj"+lista.get(i));

        if(aSwitch.isChecked() == true){
            db.open();
            System.out.println(db.ottieniTutto().toString());
            db.cancellaCliente(trova(lista.get(i)));
            //trova();
            db.close();
            adapter.remove(lista.get(i).toString());
        }else{
            Toast.makeText(this, "Attiva switch per eliminare", Toast.LENGTH_SHORT).show();
        }
        inizializzaLista();


    }

    public void sciriDB(){

            db.open();
            long id = db.inserisciCliente(aggiungi.getText().toString());
            db.close();
            adapter.add(aggiungi.getText().toString());
            aggiungi.setText("");
            inizializzaLista();

    }

    private int trova(String s){

        int x = lista.indexOf(s);
        System.out.println("forssssssssssssssssssssssss"+x);

        return listaIndici.get(x);
    }


}