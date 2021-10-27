package com.example.ciclodivitaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG=SecondActivity.class.getName();
    private static final String KEY_value=TAG+".extras.value";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView=findViewById(R.id.textView2);

        String nome=getIntent().getStringExtra(KEY_value);
        textView.setText(nome);

    }


    public static Intent getIntent(Context context, String value){
        Intent intent=new Intent(context,SecondActivity.class);
        intent.putExtra(KEY_value, value);
        return intent;

    }
}