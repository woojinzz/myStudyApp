package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Ex12SoccerActivity extends AppCompatActivity {

    TextView tvCnt,tvResult,tvRecord,tvGoal,tvFailure;
    ImageView ivMain,ivBall1,ivBall2,ivBall3;
    Animation ani1,ani2,ani3;
    int cnt ,coin=10,Failure, record;
    String stCnt, stRecord,stCoin,stFailure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_soccer);

        tvCnt = (TextView)findViewById(R.id.tvCnt);
        tvResult = (TextView)findViewById(R.id.tvResult);
        tvRecord = (TextView)findViewById(R.id.tvRecord);
        tvGoal = (TextView)findViewById(R.id.tvGoal);
        tvFailure = (TextView)findViewById(R.id.tvFailure);

        ivBall1 = (ImageView)findViewById(R.id.ivBall1);
        ivBall1.setOnClickListener(Listener);
        ivBall2 = (ImageView)findViewById(R.id.ivBall2);
        ivBall2.setOnClickListener(Listener);
        ivBall3 = (ImageView)findViewById(R.id.ivBall3);
        ivBall3.setOnClickListener(Listener);


        ani1 = AnimationUtils.loadAnimation(this, R.anim.shoot);
        ani2 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        ani3 = AnimationUtils.loadAnimation(this, R.anim.translate);

        ivMain = (ImageView) findViewById(R.id.ivMain);
        findViewById(R.id.btnCoin).setOnClickListener(Listener);

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Animation animTreanTop = AnimationUtils.loadAnimation(getApplication(), R.anim.top);
        ivMain.startAnimation(animTreanTop);
        ivBall1.startAnimation(animTreanTop);
        ivBall2.startAnimation(animTreanTop);
        ivBall3.startAnimation(animTreanTop);
    }
    View.OnClickListener Listener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ivBall1:

                    ivBall1.startAnimation(ani1);
                    if(coin<2){
                        Toast.makeText(Ex12SoccerActivity.this,"코인이 부족합니다.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //전적 카운터
                    record++;
                    stRecord = String.valueOf(record);
                    tvRecord.setText(stRecord+"회");
                    coin-=2;
                    stCoin = String.valueOf(coin);
                    tvCnt.setText(stCoin);
                    int A = (int)(Math.random()*10);
                    if(A>=0 && A<5){
                        Glide.with(Ex12SoccerActivity.this).load(R.raw.sun1).into(ivMain);
                        Toast.makeText(Ex12SoccerActivity.this,"골!!!!.",Toast.LENGTH_SHORT).show();
                        tvResult.setText("중거리 슛 성공!");
                        cnt++;//성공 카운터
                        stCnt = String.valueOf(cnt);
                        tvGoal.setText(stCnt+"회");
                    }
                    else{Glide.with(Ex12SoccerActivity.this).load(R.raw.sunno).into(ivMain);
                        Toast.makeText(Ex12SoccerActivity.this,"노골ㅜㅠ.",Toast.LENGTH_SHORT).show();
                        Failure++;//실패 카운터 stFailure
                        stFailure = String.valueOf(Failure);
                        tvFailure.setText(stFailure+"회");
                        tvResult.setText("중거리 슛 실패!");
                    }
                    break;
                case R.id.ivBall2:

                    ivBall2.startAnimation(ani2);
                    if(coin<3){
                        Toast.makeText(Ex12SoccerActivity.this,"코인이 부족합니다.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //전적 카운터
                    record++;
                    stRecord = String.valueOf(record);
                    tvRecord.setText(stRecord+"회");
                    coin-=3;
                    stCoin = String.valueOf(coin);
                    tvCnt.setText(stCoin);
                    int B = (int)(Math.random()*10);

                    if(B==1){
                        Glide.with(Ex12SoccerActivity.this).load(R.raw.sunno).into(ivMain);
                        Toast.makeText(Ex12SoccerActivity.this,"노골ㅜㅠ.",Toast.LENGTH_SHORT).show();
                        Failure++;//실패 카운터
                        stFailure = String.valueOf(Failure);
                        tvFailure.setText(stFailure+"회");
                        tvResult.setText("PK 실패!");
                    }
                    else{
                        Glide.with(Ex12SoccerActivity.this).load(R.raw.sun2).into(ivMain);
                        Toast.makeText(Ex12SoccerActivity.this,"골!!!!.",Toast.LENGTH_SHORT).show();
                        cnt++;//성공 카운터
                        stCnt = String.valueOf(cnt);
                        tvGoal.setText(stCnt+"회");
                        tvResult.setText("PK 성공!");
                    }

                    break;

                case R.id.ivBall3:

                    ivBall3.startAnimation(ani3);
                    if(coin<2){
                        Toast.makeText(Ex12SoccerActivity.this,"코인이 부족합니다.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //전적 카운터
                    record++;
                    stRecord = String.valueOf(record);
                    tvRecord.setText(stRecord+"회");
                    coin-=2;
                    stCoin = String.valueOf(coin);
                    tvCnt.setText(stCoin);
                    int C = (int)(Math.random()*10);

                    if(C >= 0 && C <= 3 ){
                        Glide.with(Ex12SoccerActivity.this).load(R.raw.sun3).into(ivMain);
                        Toast.makeText(Ex12SoccerActivity.this,"골!!!!.",Toast.LENGTH_SHORT).show();
                        cnt++;//성공 카운터
                        stCnt = String.valueOf(cnt);
                        tvGoal.setText(stCnt+"회");
                        tvResult.setText("헤딩 골 성공!");
                    }
                    else{Glide.with(Ex12SoccerActivity.this).load(R.raw.sunno).into(ivMain);
                        Toast.makeText(Ex12SoccerActivity.this,"노골ㅜㅠ.",Toast.LENGTH_SHORT).show();
                        Failure++;//실패 카운터
                        stFailure = String.valueOf(Failure);
                        tvFailure.setText(stFailure+"회");
                        tvResult.setText("해딩 골 실패!");
                    }
                    break;
                case R.id.btnCoin:
                    //전적 리셋
                    record=0;
                    //코인리셋
                    coin = 10;
                    Failure=0;
                    stCoin = String.valueOf(coin);
                    tvCnt.setText(stCoin);
                    tvResult.setText("대기중...");
                    ivMain.setImageResource(R.drawable.sunmain);


            }
        }
    };
}