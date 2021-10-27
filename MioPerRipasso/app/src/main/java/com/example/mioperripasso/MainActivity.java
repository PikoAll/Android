package com.example.mioperripasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> domande=new ArrayList<String>(Arrays.asList("Hello","dog","cat"));
    private ArrayList<String> risposta1=new ArrayList<String>(Arrays.asList("ciao","citta"));
    private ArrayList<String> risposta2=new ArrayList<String>(Arrays.asList("gatto","cane"));
    private ArrayList<String> risposta3=new ArrayList<String>(Arrays.asList("bici","gatto"));
    private Button bottone1,bottone2;
    private TextView domanda;
    private int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        domanda=findViewById(R.id.domanda);
        bottone1=findViewById(R.id.button1);
        bottone2=findViewById(R.id.button2);

        domanda.setText(domande.get(0));
        bottone1.setText(risposta1.get(0));
        bottone2.setText(risposta1.get(1));

    }


    public void rispostaClick(View view){

        int id=view.getId();


        if(id==R.id.button1){
            //Toast.makeText(getApplicationContext(),"bottone1", Toast.LENGTH_LONG).show();
            controllo(bottone1.getText().toString());
        }else if(id==R.id.button2){
            controllo(bottone2.getText().toString());
            //Toast.makeText(getApplicationContext(),"bottone2", Toast.LENGTH_LONG).show();

        }


    }

    private void controllo(String s){
        System.out.println("ora "+s+"mai");
        if(num==0){
            if(s.compareTo("ciao")==0){
                System.out.println("hey "+ s.compareTo("ciao"));
                Toast.makeText(getApplicationContext(),"risposta coretta", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"risposta errata", Toast.LENGTH_LONG).show();
            }
            settaParole();
        }else if(num==1){
            if(s.compareToIgnoreCase("cane")==0){
                Toast.makeText(getApplicationContext(),"risposta coretta", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"risposta errata", Toast.LENGTH_LONG).show();
            }
            settaParole();

        }else{
            if(s.compareToIgnoreCase("gatto")==0){
                Toast.makeText(getApplicationContext(),"risposta coretta", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"risposta errata", Toast.LENGTH_LONG).show();
            }
            settaParole();
        }

    }

    private void settaParole(){
        System.out.println("amico");
        if(num<3){
            num=num+1;
        }
        System.out.println(num);
        domanda.setText(domande.get(num));
        if(num==1){
            bottone1.setText(risposta2.get(0));
            bottone2.setText(risposta2.get(1));
        }else if(num==2){
            bottone1.setText(risposta3.get(0));
            bottone2.setText(risposta3.get(1));
        }
    }

}