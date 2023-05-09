package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class JoinActivity extends AppCompatActivity {

    TextView tvId,tvPw,tvName,tvHp,tvSex,tvArea;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        tvId = (TextView) findViewById(R.id.tvId);
        tvPw = (TextView) findViewById(R.id.tvPw);
        tvName = (TextView) findViewById(R.id.tvName);
        tvHp = (TextView) findViewById(R.id.tvHp);
        tvSex = (TextView) findViewById(R.id.tvSex);
        tvArea = (TextView) findViewById(R.id.tvArea);

        //전달받은 데이터 받기
        Intent getData = getIntent();
        String id = getData.getStringExtra("id");
        String pw = getData.getStringExtra("pw");
        String name = getData.getStringExtra("name");
        String hp = getData.getStringExtra("hp");
        String sex = getData.getStringExtra("sex");
        String area = getData.getStringExtra("area");

        tvId.setText(id);
        tvPw.setText(pw);
        tvName.setText(name);
        tvHp.setText(hp);
        tvSex.setText(sex);
        tvArea.setText(area);



    }
}