package com.example.calcoloanni;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import static java.util.Calendar.*;

public class MainActivity extends AppCompatActivity {

    private TextView mostraEta;
    private Button button;
    private EditText inserisciData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostraEta=findViewById(R.id.textView); //abbiamo collagato il dato con il coso del layout
        button=findViewById(R.id.button);
        inserisciData=findViewById(R.id.editTextDate);


        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                //cosa far al tocco sul bottone??
                String inserisci=inserisciData.getText().toString();
                int dataNascita= Integer.parseInt(inserisci);
                int eta=calcolaData(dataNascita);

                mostraEta.setText(String.valueOf(eta));
            }
        });



    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private int calcolaData(int dataDiNascita){

        //prendere anno corrente direttamente
        Calendar calendar = getInstance();
        int anno=calendar.getWeekYear();
        return anno-dataDiNascita;
    }

}