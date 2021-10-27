package com.example.timeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private SeekBar seekbar;
    private TextView textView;

    private CountDownTimer countDownTimer;  //classe che mi permette conto alla rovescia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonStart);
        seekbar=findViewById(R.id.seekBar);
        textView=findViewById(R.id.timerText);


        seekbar.setMax(600);
        seekbar.setProgress(30);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTimerText(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //blocchiamo la seekBar
                seekbar.setEnabled(false);

                countDownTimer=new CountDownTimer(seekbar.getProgress()*1000+100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        updateTimerText((int)millisUntilFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                            //a fine time ressettiamo l'app per farla rfunzionare
                        resetTimer();
                        MediaPlayer media=MediaPlayer.create(getApplicationContext(),R.raw.canzone);
                        media.start();
                    }
                };
                countDownTimer.start();
            }
        });

    }


    private void updateTimerText(int secondLeft){
        int minuti=secondLeft/60;
        int second=secondLeft-minuti*60;

        String secondString=String.valueOf(second);

        if(second<10){
            secondString="0"+secondString;
        }

        textView.setText(String.valueOf(minuti)+":"+secondString);

    }

    private void resetTimer(){
        textView.setText("0:30");
        seekbar.setProgress(30);
        countDownTimer.cancel();
        seekbar.setEnabled(true);

    }

}