package com.example.alertviewfinestradialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder=new AlertDialog.Builder(this);
        builder.setMessage("caricamento in corso");

        builder.setPositiveButton("Discard", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"discarde",Toast.LENGTH_LONG).show();
                dialog.dismiss();   //chiudi finestra
            }
        });

        builder.setNegativeButton("cancella", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"cancella",Toast.LENGTH_LONG).show();
                dialog.dismiss();   //chiudi finestra

            }
        });

        alertDialog=builder.create();
        alertDialog.show();
    }
}