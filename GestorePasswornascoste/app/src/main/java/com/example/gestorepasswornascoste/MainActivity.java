package com.example.gestorepasswornascoste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bottone;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inizializzo
        bottone=findViewById(R.id.button);
        text=findViewById(R.id.editTextTextPassword);

        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass=text.getText().toString();      //cosi ci salviamo quello che viene scritto nella casella di testo
                if(pass.equals("123") && !pass.isEmpty()){
                    Intent intent=SecondActivity.intent(MainActivity.this);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"password non corretta", Toast.LENGTH_SHORT).show(); // pop up
                }

            }
        });

    }
}