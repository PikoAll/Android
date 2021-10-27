package com.example.giocomoltiplicazioni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mDomanda,mTimer,mRisultato;
    private Button bottone1,bottone2,bottone3,bottone4;
    private CountDownTimer countDownTimer;  //per fare conto alla rovescia
    private Random random;
    private int risultato=0,punteggio=0,risultatiTotali=0;
    private long maxTime=30000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDomanda=findViewById(R.id.textView);
        mRisultato=findViewById(R.id.risultato);
        mTimer=findViewById(R.id.timer);

        bottone1=findViewById(R.id.button1);
        bottone2=findViewById(R.id.button2);
        bottone3=findViewById(R.id.button3);
        bottone4=findViewById(R.id.button4);

        random=new Random();

        countDownTimer=new CountDownTimer(/*Tempo massimo 30 sec*/maxTime,/*intervallo di tempo*/ 1000L ) {
            @Override
            public void onTick(long millisUntilFinished) {
                //cosa fare ogni secondo
                maxTime=maxTime-1000;
                mTimer.setText(millisUntilFinished/1000 +" sec");

            }

            @Override
            public void onFinish() {
                //cosa fare a tempo finito
                mRisultato.setText("hai fatto " + risultato+" su totali di "+risultatiTotali );

                //appena il gioco e finito i bottoni non devono essere cliccabbili
                bottone1.setEnabled(false);
                bottone2.setEnabled(false);
                bottone3.setEnabled(false);
                bottone4.setEnabled(false);
                mTimer.setText("hai finito il tempo");
            }
        }.start();

        List<Integer> lista=generaNumero();
        setTextBottone(lista);

    }

    // ora vado a mettere android:onClick nel file xml per collegare direttamente i pulsanti a questo metodo e evitare altre cose
    public void rispostaClick(View view){
        int id=view.getId();
        Button b=null;
        risultatiTotali++;

        List<Integer> lista=generaNumero();
        setTextBottone(lista);


        if(id==R.id.button1){
            rispostaCorretta(bottone1);
        }else if(id==R.id.button2){
            rispostaCorretta(bottone2);
        }else if(id==R.id.button3){
            rispostaCorretta(bottone3);
        }else if (id==R.id.button4){
            rispostaCorretta(bottone4);
        }

        System.out.println("tuo punteggio "+punteggio+" total "+risultatiTotali);

    }

    private List<Integer> generaNumero(){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<4;i++){
            int rand1=random.nextInt(10)+1; //compresi 1 e 10
            int rand2=random.nextInt(10)+1; //compresi 1 e 10
            list.add(rand1*rand2);
            if(i==0){
                mDomanda.setText("qual'e il risultato di "+rand1+" * "+rand2);
                risultato=rand1*rand2;
            }
        }
        return list;
    }

    private boolean rispostaCorretta(Button b){
        if(b.getText().toString().equals(String.valueOf(risultato))){
            punteggio++;
            return true;
        }
        return false;

    }

    private void setTextBottone(List<Integer> lista){

        System.out.println("Holaaa1"+lista);
        int x=random.nextInt(4);
        if(x!=0) {
            Integer temp = lista.get(0);
            lista.set(0, lista.get(x));
            lista.set(x, temp);
        }

        System.out.println("Holaaa22"+lista);







        bottone1.setText(String.valueOf(lista.get(0)));
        bottone2.setText(String.valueOf(lista.get(1)));
        bottone3.setText(String.valueOf(lista.get(2)));
        bottone4.setText(String.valueOf(lista.get(3)));

    }


}