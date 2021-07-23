package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivPlay;
    String link = "https://www.dropbox.com/s/8wbtwq24i95yayd/sample_music.mp3?dl=0";
    boolean musicPlaying = false;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlay = findViewById(R.id.ivPlay);

        ivPlay.setBackgroundResource(R.mipmap.play_foreground);

        serviceIntent = new Intent(this, MyPlayService.class);

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!musicPlaying) {
                    playAudio();
                    ivPlay.setImageResource(R.mipmap.stop_foreground);
                    musicPlaying = true;
                } else {
                    stopPlayService();
                    ivPlay.setImageResource(R.mipmap.play_foreground);
                }
            }
        });
    }

    private void stopPlayService() {
        try {
            stopService(serviceIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void playAudio() {
        serviceIntent.putExtra("AudioLink", link);
        try {
            startService(serviceIntent);
        } catch (SecurityException e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}