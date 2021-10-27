package com.example.bottonicambianoparola;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bottoneIndietro,bottoneAvanti;
    private TextView testo;
    private List<String> lista;
    private static int pos=0;
    private static final String salva=MainActivity.class.getSimpleName()+".save_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        bottoneIndietro=findViewById(R.id.buttonIndietro);
        bottoneAvanti=findViewById(R.id.buttonAvanti);
        testo=findViewById(R.id.textView);

        setLista();


    }


    public void clickBottoni(View v){
        int id=v.getId();

        if(id==R.id.buttonIndietro){

            if(pos==0){
                Toast.makeText(getApplicationContext(),"non posso andare indietro",Toast.LENGTH_SHORT).show();
            }else{
                pos--;
                testo.setText(lista.get(pos).toString());
            }

        }else if(id==R.id.buttonAvanti){

            if(pos==lista.size()-1){
                Toast.makeText(getApplicationContext(),"non posso andare avanti",Toast.LENGTH_SHORT).show();
            }else{
                pos++;
                testo.setText(lista.get(pos).toString());
            }

        }



    }

    private void setLista(){
        System.out.println("ciao");
        lista= Arrays.asList("ciao","bello","gianni","pinotto");
        testo.setText(lista.get(pos).toString());
        System.out.println("hhola "+lista.get(1));
        System.out.println("hhola44444 "+lista.size());


    }

    /*
   questo serve per esempio non interrompere l'app mentr si gira lo schermo e l if di sopra serve a questo
   cioe se null non e sucesso  niente altrimenti riprende il vecchio contatore ni stu caso
    */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("salva",pos);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       pos= savedInstanceState.getInt("salva",0);
    }


}