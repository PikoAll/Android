package com.example.saveistance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            i=0;
        }else {
            i=savedInstanceState.getInt("KEY");
        }

        textView1=findViewById(R.id.testo);

      //  new Thread(new Run()).start();


    }
    //thread
    private class Run implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000L);  //1sec

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        i++;
                        textView1.setText(String.valueOf(i));
                    }
                });
            }
        }
    }

    /*
    questo serve per esempio non interrompere l'app mentr si gira lo schermo e l if di sopra serve a questo
    cioe se null non e sucesso  niente altrimenti riprende il vecchio contatore ni stu caso
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Key",i);
    }
}