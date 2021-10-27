package com.example.quizappbellacompleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Quiz quiz[];
   // private ArrayList<String>domande= Arrays("quali di questi non e un marchio di auto", "quali di questi non e un mafioso", "quanti regioni ha l'italia");
    private ArrayList<String> domande = new ArrayList<String>(Arrays.asList("quali di questi non e un marchio di auto", "quali di questi non e un mafioso", "quanti regioni ha l'italia"));
    private ArrayList<String> risposta1 = new ArrayList<String>(Arrays.asList("audi", "renault", "asus","bmw"));
    private ArrayList<String> risposta2 = new ArrayList<String>(Arrays.asList("riina", "PippoTraslochi", "provenzano","Liggio"));

    private Button bottone1,bottone2,bottone3, bottone4,bottoneAvanti;
    private TextView testo;
    private int num=0;
    private static int currentElement=0;
    private int punteggio=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // System.out.println(domande.get(0));

        bottone1=findViewById(R.id.button1);
        bottone2=findViewById(R.id.button2);
        bottone3=findViewById(R.id.button3);
        bottone4=findViewById(R.id.button4);
        bottoneAvanti=findViewById(R.id.bottoveAvanti);
        testo=findViewById(R.id.textView);
        bottoneAvanti.setText("Avanti");

        quiz=new Quiz[]{
                new Quiz(domande.get(0),risposta1.get(0),risposta1.get(1),risposta1.get(2),risposta1.get(3),3),
                new Quiz(domande.get(1),risposta2.get(0),risposta2.get(1),risposta2.get(2),risposta2.get(3),2)
              //  new Quiz("","","","","",0)
        };

        setTesto();

    }

    //evito di fare il metodo sentonclick per ogni bottone mettendo nel file xml dove ci sono i bottoni android:onClick e passo il nome del metodo
    public void clickBottone(View v){
        int id=v.getId();           //cosi riesco a prendere l'id del bottone cliccato
        System.out.println("ciao "+id);
        Button b;

        //ora tramite una serie di if capisco il bottone
        if(id==R.id.button1){
            attivaDisattivaBottoni(false,bottone1,bottone2,bottone3, bottone4);
            num=1;
        }else if(id==R.id.button2){
            num=2;
            attivaDisattivaBottoni(false,bottone1,bottone2,bottone3, bottone4);
        }else if(id==R.id.button3){
            attivaDisattivaBottoni(false,bottone1,bottone2,bottone3, bottone4);
             num=3;
        }else if (id==R.id.button4){
            attivaDisattivaBottoni(false,bottone1,bottone2,bottone3, bottone4);
            num=4;
        }else if(id==R.id.bottoveAvanti){
            if(num==0){
                Toast.makeText(getApplicationContext(),"non hai selezionato nulla",Toast.LENGTH_SHORT).show();
            }else {
                currentElement++;
                if (currentElement < quiz.length) {
                    attivaDisattivaBottoni(true,bottone1,bottone2,bottone3, bottone4);
                    setTesto();

                }else{
                    Intent intent=PointActivity.getIstanceIntent(MainActivity.this,punteggio,quiz.length);
                    startActivity(intent);
                    finish(); //finisce l'app se vai indietro si chiude
                }
            }

            num=0;
        }

        if(num!=0){
            if(quiz[currentElement].vediamoSeCorretta(num)){
                Toast.makeText(getApplicationContext(),"risposta e corretta",Toast.LENGTH_SHORT).show();
                punteggio++;

            }else{
                Toast.makeText(getApplicationContext(),"risposta e sbagliata ",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void setTesto(){
        bottone1.setText(quiz[currentElement].getRisposta1());
       bottone2.setText(quiz[currentElement].getRisposta2());
       bottone3.setText(quiz[currentElement].getRisposta3());
       bottone4.setText(quiz[currentElement].getRisposta4());
        testo.setText(quiz[currentElement].getDomanda());

    }

    //il secondo parametro indica una specie di insieme per tutti i bottoni quindi una modifica a lui modifica tutti i bottoni
    private void attivaDisattivaBottoni(boolean fl, Button... buttons){

        for(int i=0; i<buttons.length;i++){
            buttons[i].setEnabled(fl);
        }

    }
}