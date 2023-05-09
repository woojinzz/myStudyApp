package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Ex5DataActivity extends AppCompatActivity {

    public static String id, hp;
    EditText etStaticId, etStaticHp,etId,etHp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_data);

        //id 연동
        etStaticId = (EditText) findViewById(R.id.etStaticId);
        etStaticHp = (EditText) findViewById(R.id.etStaticHp);
        etId = (EditText) findViewById(R.id.etId);
        etHp = (EditText) findViewById(R.id.etHp);

        findViewById(R.id.btnStatic).setOnClickListener(mClickListener);
        findViewById(R.id.btnTrans).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnStatic:

                    id = etStaticId.getText().toString();
                    hp = etStaticHp.getText().toString();

                    etStaticId.setText("");
                    etStaticHp.setText("");
                    Toast.makeText(Ex5DataActivity.this,"저장되었습니다.",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnTrans:
                    String getId = etId.getText().toString();
                    String getHp = etHp.getText().toString();

                    Intent intent1 = new Intent(Ex5DataActivity.this, Ex5DataReceviveActivity.class);
                    intent1.putExtra("id",getId);
                    intent1.putExtra("hp",getHp);
                    startActivity(intent1);
                    break;


            }
        }
    };
}