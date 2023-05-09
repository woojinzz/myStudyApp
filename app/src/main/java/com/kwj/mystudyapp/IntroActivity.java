package com.kwj.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    TextView tvCome, tvApp;
    ImageView imgIntro,imgW,imgE,imgL,imgCome;
    Animation ani1,ani2,ani3,ani4,ani5,ani6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        tvApp = (TextView) findViewById(R.id.tvApp);
        imgCome = (ImageView) findViewById(R.id.imgCome);
        imgW = (ImageView) findViewById(R.id.imgW);
        imgE = (ImageView) findViewById(R.id.imgE);
        imgL = (ImageView) findViewById(R.id.imgL);
        imgIntro = (ImageView) findViewById(R.id.imgIntro);
        imgIntro.setOnClickListener(Listener);


        ani1 = AnimationUtils.loadAnimation(this, R.anim.top);
        ani2 = AnimationUtils.loadAnimation(this, R.anim.top2);
        ani3 = AnimationUtils.loadAnimation(this, R.anim.top3);
        ani4 = AnimationUtils.loadAnimation(this, R.anim.intro);
        ani5 = AnimationUtils.loadAnimation(this, R.anim.move);
        ani6 = AnimationUtils.loadAnimation(this, R.anim.alpha);


    }
    @Override
    protected void onStart()
    {
        super.onStart();

        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable(){
            @Override
            public void run() {
                imgW.setImageResource(R.drawable.imgw);
                imgW.startAnimation(ani1);}
        },1000);
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable(){
            @Override
            public void run() {
                imgE.setImageResource(R.drawable.imge);
                imgE.startAnimation(ani2);}
        },1500);
        Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable(){
            @Override
            public void run() {
                imgL.setImageResource(R.drawable.imgl);
                imgL.startAnimation(ani3);}
        },2000);

        Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable(){
            @Override
            public void run() {
                imgIntro.startAnimation(ani5);}
        },2000);

        Handler handler5 = new Handler();
        handler5.postDelayed(new Runnable(){
            @Override
            public void run() {
                imgCome.startAnimation(ani6);}
        },2000);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent1 = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        },7000);

    }

    View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgIntro:

                    imgIntro.startAnimation(ani1);



                    break;

            }
        }
    };
}