package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Ex9VideoMainActivity extends AppCompatActivity {

    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex9_video_main);
        vv =(VideoView) findViewById(R.id.videoView);

        findViewById(R.id.btnAct1).setOnClickListener(mClick);
        findViewById(R.id.btnAct2).setOnClickListener(mClick);
        findViewById(R.id.btnAct3).setOnClickListener(mClick);
        Uri videoUir = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videogz);
        vv.setMediaController(new MediaController(this));
        vv.setVideoURI(videoUir);

    }
    View.OnClickListener mClick = new View.OnClickListener(){

        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnAct1:
                    vv.start();
                    break;
                case R.id.btnAct2:
                    vv.pause();
                    break;
                case R.id.btnAct3:
                    vv.stopPlayback();
                    break;

            }

        }
    };


    }
