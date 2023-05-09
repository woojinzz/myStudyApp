package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Ex4GifActivity extends AppCompatActivity {

    ImageView ivMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_gif);

       ivMain = (ImageView) findViewById(R.id.ivMain);
       findViewById(R.id.btnImg1).setOnClickListener(mClickListener);
        findViewById(R.id.btnImg2).setOnClickListener(mClickListener);
        findViewById(R.id.btnImg3).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnImg1:
                    Glide.with(Ex4GifActivity.this).load(R.raw.imgzg5).into(ivMain);
                    break;
                case R.id.btnImg2:
                    Glide.with(Ex4GifActivity.this).load(R.raw.imgzg6).into(ivMain);
                    break;
                case R.id.btnImg3:
                    Glide.with(Ex4GifActivity.this).load(R.raw.imgzg7).into(ivMain);
                    break;

            }
        }
    };

}