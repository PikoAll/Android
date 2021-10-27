package com.example.tris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MultiActivity extends AppCompatActivity {

    private boolean fl=false;

    private Button bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        bottone1=findViewById(R.id.button1);
        bottone2=findViewById(R.id.button2);
        bottone3=findViewById(R.id.button3);
        bottone4=findViewById(R.id.button4);
        bottone5=findViewById(R.id.button5);
        bottone6=findViewById(R.id.button6);
        bottone7=findViewById(R.id.button7);
        bottone8=findViewById(R.id.button8);
        bottone9=findViewById(R.id.button9);

    }

    public static Intent getIstanceIntent(Context context){
        Intent intent=new Intent(context,MultiActivity.class);
        return intent;

    }

    public void clickBottone(View v){

        int id=v.getId();

        if(id==R.id.button1){

            if(fl==false){
                bottone1.setText("x");
                fl=true;
            }else{
                bottone1.setText("0");
                fl=false;
            }
            bottone1.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);


        }else if(id==R.id.button2){
            if(fl==false){
                bottone2.setText("x");
                fl=true;
            }else{
                bottone2.setText("0");
                fl=false;
            }
            bottone2.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);



        }else if(id==R.id.button3){
            if(fl==false){
                bottone3.setText("x");
                fl=true;
            }else{
                bottone3.setText("0");
                fl=false;
            }
            bottone3.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);


        }else if(id==R.id.button4){
            if(fl==false){
                bottone4.setText("x");
                fl=true;
            }else{
                bottone4.setText("0");
                fl=false;
            }
            bottone4.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);


        }else if(id==R.id.button5){
            if(fl==false){
                bottone5.setText("x");
                fl=true;
            }else{
                bottone5.setText("0");
                fl=false;
            }
            bottone5.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);


        }else if(id==R.id.button6){
            if(fl==false){
                bottone6.setText("x");
                fl=true;
            }else{
                bottone6.setText("0");
                fl=false;
            }
            bottone6.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);


        }else if(id==R.id.button7){
            if(fl==false){
                bottone7.setText("x");
                fl=true;
            }else{
                bottone7.setText("0");
                fl=false;
            }
            bottone7.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);


        }else if(id==R.id.button8){
            if(fl==false){
                bottone8.setText("x");
                fl=true;
            }else{
                bottone8.setText("0");
                fl=false;
            }
            bottone8.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);



        }else if(id==R.id.button9){
            if(fl==false){
                bottone9.setText("x");
                fl=true;
            }else{
                bottone9.setText("0");
                fl=false;
            }
            bottone9.setEnabled(false);
            controlloSituazione(bottone1,bottone2,bottone3,bottone4,bottone5,bottone6,bottone7,bottone8,bottone9);


        }


    }


    private void controlloSituazione(Button...b){
        int fl=9;

        System.out.println("dentro il metodo");
        for(int i=0; i<9; i++){
            //System.out.println(b[i].getText().toString().equals(""));
            //System.out.println(!b[i].getText().toString().equals(""));
            if(b[i].getText().toString().equals("")){
                //fl1=true;
                break;
            }else{
                //fl--;
                //Toast.makeText(getApplicationContext(),"Parita",Toast.LENGTH_SHORT).show();
                fl--;
            }

        }

        //Controllo vincita
        if((bottone1.getText().toString().equals("x") && bottone2.getText().toString().equals("x") && bottone3.getText().toString().equals("x")) ||
            (bottone1.getText().toString().equals("x") && bottone5.getText().toString().equals("x") && bottone9.getText().toString().equals("x")) ||
                    (bottone1.getText().toString().equals("x") && bottone4.getText().toString().equals("x") && bottone7.getText().toString().equals("x")) ||
                    (bottone4.getText().toString().equals("x") && bottone5.getText().toString().equals("x")) && bottone6.getText().toString().equals("x")||
                    (bottone7.getText().toString().equals("x") && bottone8.getText().toString().equals("x") && bottone9.getText().toString().equals("x"))||
                    (bottone2.getText().toString().equals("x") && bottone5.getText().toString().equals("x") && bottone8.getText().toString().equals("x"))||
                    (bottone3.getText().toString().equals("x") && bottone6.getText().toString().equals("x")) && bottone9.getText().toString().equals("x")||
                    (bottone3.getText().toString().equals("x") && bottone5.getText().toString().equals("x")) && bottone7.getText().toString().equals("x")){

            System.out.println("sucaa");

            Toast.makeText(getApplicationContext(),"HA VINTO 'X'",Toast.LENGTH_SHORT).show();

            for(int i=0; i<b.length;i++){
                b[i].setEnabled(false);
            }

            Intent intent=VittoriaActivity.getIstanceIntent(MultiActivity.this, "X");
            startActivity(intent);

        }
        if((bottone1.getText().toString().equals("0") && bottone2.getText().toString().equals("0") && bottone3.getText().toString().equals("0")) ||
                (bottone1.getText().toString().equals("0") && bottone5.getText().toString().equals("0") && bottone9.getText().toString().equals("0")) ||
                (bottone1.getText().toString().equals("0") && bottone4.getText().toString().equals("0") && bottone7.getText().toString().equals("0")) ||
                (bottone4.getText().toString().equals("0") && bottone5.getText().toString().equals("0")) && bottone6.getText().toString().equals("0")||
                (bottone7.getText().toString().equals("0") && bottone8.getText().toString().equals("0") && bottone9.getText().toString().equals("0"))||
                (bottone2.getText().toString().equals("0") && bottone5.getText().toString().equals("0") && bottone8.getText().toString().equals("0"))||
                (bottone3.getText().toString().equals("0") && bottone6.getText().toString().equals("0")) && bottone9.getText().toString().equals("0")||
                (bottone3.getText().toString().equals("0") && bottone5.getText().toString().equals("0")) && bottone7.getText().toString().equals("0")){

            System.out.println("sucaa");

            Toast.makeText(getApplicationContext(),"HA VINTO '0'",Toast.LENGTH_SHORT).show();

            for(int i=0; i<b.length;i++){
                b[i].setEnabled(false);
            }

            Intent intent=VittoriaActivity.getIstanceIntent(MultiActivity.this, "X");
            startActivity(intent);

        }

        //PARITA
        if(fl==0){
            Toast.makeText(getApplicationContext(),"Parita",Toast.LENGTH_SHORT).show();
        }

    }

}