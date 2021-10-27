package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> lista;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);


        lista=new ArrayList<>();
        inizializzaLista(50);
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);

        //per rendere cliccabile la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //implemento un toast che e un pop up
                Toast.makeText(MainActivity.this, "posizione " + i+" nome: "+lista.get(i), Toast.LENGTH_SHORT).show();
                System.out.println(lista.get(i));

            }
        });

    }

    public void inizializzaLista(int numero){

        for (int i=0; i<numero; i++){
            lista.add("Persone "+String.valueOf(i));
        }


    }

}