package com.kwj.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ex20FriendAddActivity extends AppCompatActivity {
    Switch swSex;
    TextView tvSex;

    EditText etName, etHp, etAddr, etAge;


    Button btnAdd;
    //전달할 변수들
    String sendId, sendPw, sendName, sendHp, selectSex="남자";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex20_add);

        etAddr = (EditText) findViewById(R.id.etAddr);
        etAge = (EditText) findViewById(R.id.etAge);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);

        swSex = (Switch) findViewById(R.id.swSex);
        tvSex = (TextView) findViewById(R.id.tvSex);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        swSex = findViewById(R.id.swSex);
        swSex.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvSex.setText("여자");
                    selectSex ="여자";
                } else {
                    tvSex.setText("남자");
                    selectSex = "남자";
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String name = etName.getText().toString();
                String hp = etHp.getText().toString();
                String addr = etAddr.getText().toString();
                String sex = selectSex;
                int age = Integer.parseInt(etAge.getText().toString());
                //리스트뷰 어댑터에 처리하는부분...
                Ex20FriendsListActivity.setData(name,hp,addr,sex,age);

                //값자리 초기화
                etName.setText("");
                etHp.setText("");
                etAddr.setText("");
                etAge.setText("");
            }
        });
    }
}