package com.example.yyl.myapplication0;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    private Button btn_play;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.advice);


        btn_play = (Button)findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(mediaPlayer != null){
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                            Toast.makeText(MainActivity.this,"stop 播放",Toast.LENGTH_SHORT).show();
                        }else {
                            mediaPlayer.start();
                            Toast.makeText(MainActivity.this,"stop 播放",Toast.LENGTH_SHORT).show();
                        }
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"false",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}
