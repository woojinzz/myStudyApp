package com.kwj.mystudyapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex10PlayerMainActivity extends AppCompatActivity {

    VideoView vv;
    TextView tvPlayer,tvMusic2;
    String[]  act= {"노래 재생중","노래 일시정지중"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_player_main);
        vv =(VideoView) findViewById(R.id.videoView);

        findViewById(R.id.btnAct1).setOnClickListener(mClick);
        findViewById(R.id.btnAct2).setOnClickListener(mClick);
        findViewById(R.id.btnAct3).setOnClickListener(mClick);
        tvPlayer = (TextView)findViewById(R.id.tvMsg);
        tvMusic2 = (TextView)findViewById(R.id.tvMusic2);
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
                    tvPlayer.setText(act[0]);

                    break;
                case R.id.btnAct2:
                    vv.pause();
                    tvPlayer.setText("노래 일시정지중.");
                    break;
                case R.id.btnAct3:
                    vv.stopPlayback();
                    break;

            }

        }
    };


    }
