package com.kwj.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex24ProfileActivity extends AppCompatActivity {

    EditText etId, etPw,etName,etHp;
    Button btnCheck, btnOk;
    Switch switchView;
    TextView tvSex,tvAreaText;
    Spinner spArea;

    String[] items = {"대전","대구","부산","서울","인천","광주"};
    String temp = "";//스피너 선택값 저장변수
    String sendAddr = "서울";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_join);

        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);

        tvAreaText = (TextView) findViewById(R.id.tvAreaText);

        //스위치
        tvSex = findViewById(R.id.tvSex);
        switchView = findViewById(R.id.switchView);

        //스피너
        Spinner spinner = (Spinner) findViewById(R.id.spArea);
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
                tvAreaText.setText(items[position]);

                temp = items[position];
                Log.d("스피너테스트", "선택값 저장된 변수 temp : " + temp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sendAddr= "서울";
            }
        });

        findViewById(R.id.btnCheck).setOnClickListener(mClickListener);
        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
        switchView.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvSex.setText("여자");
                } else {
                    tvSex.setText("남자");
                }

            }
        });
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btnJoin:
                    String getId = etId.getText().toString();
                    String getPw = etPw.getText().toString();
                    String getName = etName.getText().toString();
                    String getHp = etHp.getText().toString();
                    String getSex = tvSex.getText().toString();



                    Toast.makeText(Ex24ProfileActivity.this,"저장되었습니다.",Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(Ex24ProfileActivity.this, JoinActivity.class);
                    intent1.putExtra("id",getId);
                    intent1.putExtra("pw",getPw);
                    intent1.putExtra("name",getName);
                    intent1.putExtra("hp",getHp);
                    intent1.putExtra("sex",getSex);
                    intent1.putExtra("area",sendAddr);
                    startActivity(intent1);
                    break;


            }
        }
    };






}