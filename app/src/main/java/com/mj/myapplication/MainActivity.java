package com.mj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startPlaying, stopPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPlaying=(Button)findViewById(R.id.start_plying);
        stopPlaying=(Button)findViewById(R.id.stop_playing);


        startPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, MediaPlayerService.class));
            }
        });
        stopPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, MediaPlayerService.class));

            }
        });


    }
}
