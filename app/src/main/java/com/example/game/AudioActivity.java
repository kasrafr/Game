package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPlay,btnPause;
    MediaPlayer mplayer;
    SeekBar voloumebar;
    SeekBar scrubbar;
    AudioManager audiomaneger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        //
        voloumebar =findViewById(R.id.Volume_bar);
        btnPause=findViewById(R.id.btn_pause);
        btnPlay=findViewById(R.id.btn_play);
        scrubbar=findViewById(R.id.scrub_bar);
        // Audio Manager
        audiomaneger= (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxvolume=audiomaneger.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvolume=audiomaneger.getStreamVolume(AudioManager.STREAM_MUSIC);
        // volume
        voloumebar.setProgress(curvolume);
        voloumebar.setMax(maxvolume);
        voloumebar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                audiomaneger.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //position
        mplayer=MediaPlayer.create(this,R.raw.demoaudio);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubbar.setProgress(mplayer.getCurrentPosition());
            }
        },0,1000);
        scrubbar.setMax(mplayer.getDuration());
        scrubbar.setProgress(0);
        scrubbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mplayer!=null && fromUser) {
                    mplayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        //
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        mplayer=MediaPlayer.create(this,R.raw.demoaudio);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_play :
                mplayer.start();
                break;
            case R.id.btn_pause:
                mplayer.pause();
                break;
            default: break;
        }
    }
}