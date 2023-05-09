package com.kwj.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex5DataReceviveActivity extends AppCompatActivity {

    TextView tvId, tvHp,tvStaticId,tvStaticHp;
    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_data_receive);

        tvId = (TextView) findViewById(R.id.tvId);
        tvHp = (TextView) findViewById(R.id.tvHp);
        tvStaticId = (TextView) findViewById(R.id.tvStaticId);
        tvStaticHp = (TextView) findViewById(R.id.tvStaticHp);
        btnGet = (Button)findViewById(R.id.btnGet);


        //전달받은 데이터 받기
        Intent getData = getIntent();
        String id = getData.getStringExtra("id");
        String hp = getData.getStringExtra("hp");
        tvId.setText(id);
        tvHp.setText(hp);

        //onCreate()메서드 안에서 단독형 클릭 이벤트처리
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvStaticId.setText(Ex5DataActivity.id);
                tvStaticHp.setText(Ex5DataActivity.hp);
            }
        });
    }
}