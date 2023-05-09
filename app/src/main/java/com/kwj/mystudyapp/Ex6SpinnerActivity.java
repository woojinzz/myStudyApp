package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Ex6SpinnerActivity extends AppCompatActivity {
    TextView textView;
    ImageView img1;
    String[] items = {"안드로이드","아이폰","PC프로그램","테블릿"};
    String temp = "";//스피너 선택값 저장변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex6_spinner);

        img1 = (ImageView) findViewById(R.id.img1);

        textView = (TextView) findViewById(R.id.tvSel);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);

        // 스피너에서 선택 했을 경우 이벤트 처리
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);

                temp = items[position];
                Log.d("스피너테스트", "선택값 저장된 변수 temp : " + temp);
                if(position==0){
                    Toast.makeText(Ex6SpinnerActivity.this,"첫번째 항목",Toast.LENGTH_SHORT).show();
                }
                else if(position==1){
                    Toast.makeText(Ex6SpinnerActivity.this,"두번째 항목",Toast.LENGTH_SHORT).show();
                }
                else if(position==3){
                    Toast.makeText(Ex6SpinnerActivity.this,"세번째 항목",Toast.LENGTH_SHORT).show();
                }
                else if(position==4){
                    Toast.makeText(Ex6SpinnerActivity.this,"네번째 항목",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("선택 : ");
            }
        });

    }
}