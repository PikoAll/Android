package com.example.tris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bottoneC,bottoneM;
    private TextView testo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottoneC=findViewById(R.id.buttonCPU);
        bottoneM=findViewById(R.id.buttonMulti);

        testo=findViewById(R.id.textView);

    }



    public void clickBottone(View v){

        int id=v.getId();

        if(id==R.id.buttonCPU){
            Toast.makeText(getApplicationContext(),"ancora in fase di costruzione",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.buttonMulti){
            Intent intent=MultiActivity.getIstanceIntent(MainActivity.this);
            startActivity(intent);
        }

    }

}