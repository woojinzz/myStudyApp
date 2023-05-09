package com.kwj.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Ex12SoccerStartActivity extends AppCompatActivity {

    ImageView imgStart,imgMain;
    Animation ani1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_soccer_start);

        imgStart = (ImageView)findViewById(R.id.imgStart);
        imgStart.setOnClickListener(Listener);

        imgMain = (ImageView)findViewById(R.id.imgMain);
        imgMain.setOnClickListener(Listener);

        ani1 = AnimationUtils.loadAnimation(this, R.anim.alpha);


    }
    @Override
    protected void onStart()
    {
        super.onStart();

        Animation animTreanTop = AnimationUtils.loadAnimation(getApplication(), R.anim.top);
        imgStart.startAnimation(animTreanTop);
    }
    View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgStart:

                    imgStart.startAnimation(ani1);
                    Intent intent1 = new Intent(Ex12SoccerStartActivity.this, Ex12SoccerActivity.class);
                    startActivity(intent1);


                    break;

            }
        }
    };
}