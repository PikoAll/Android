package com.example.alertviewpopupsullaschermata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        builder=new AlertDialog.Builder(this);

        LayoutInflater inflater=this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_layout,null);
        builder.setView(dialogView);

        EditText editText=dialogView.findViewById(R.id.editText);


        builder.setMessage("caricamento in corso");

        builder.setPositiveButton("conferma", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s=editText.get
                Toast.makeText(getApplicationContext(),"discard",Toast.LENGTH_LONG).show();

                // per chiudere la finistra
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"cancel",Toast.LENGTH_LONG).show();
                // per chiudere la finistra
                dialog.dismiss();
            }
        });


        alertDialog=builder.create();

        alertDialog.show();



    }
}