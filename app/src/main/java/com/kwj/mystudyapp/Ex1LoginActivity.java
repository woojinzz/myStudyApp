package com.kwj.mystudyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex1LoginActivity extends AppCompatActivity {

    //아이디 저장을 위해서 내부 저장을 위해서 변수 선언
    private boolean saveLoginData;
    private SharedPreferences appData;
    CheckBox cbId;
    String id = "";
    EditText etId, etPw;

    TextView tvJoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_login);
        //id연동
        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);
        findViewById(R.id.btnLogin).setOnClickListener(mClickListener);
        tvJoin = (TextView) findViewById(R.id.tvJoin);

        //내부적으로 저장되어있는 데이타가 있다면 가져오기
        //------------------------------------------------
        appData = getSharedPreferences("appData", MODE_PRIVATE);
        cbId = (CheckBox) findViewById(R.id.cbId);
        load();
        //------------------------------------------------

        cbId.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbId.isChecked()==true)
                {
                    Toast.makeText(getApplication(), "아이디저장 체크가 되었습니다.", Toast.LENGTH_SHORT).show();
                    saveId();
                }
                else
                {
                    Toast.makeText(getApplication(), "아이디저장 해제 되었습니다.", Toast.LENGTH_SHORT).show();
                    etId.setText("");
                }

            }
        }) ;

        tvJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView 클릭될 시 할 코드작성
                Intent intent1 = new Intent(Ex1LoginActivity.this, Ex1JoinActivity.class);
                startActivity(intent1);
            }
        });


    }
    private void saveId() {
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();

        // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
        // 저장시킬 이름이 이미 존재하면 덮어씌움
        editor.putBoolean("SAVE_LOGIN_DATA", cbId.isChecked());
        editor.putString("ID", etId.getText().toString().trim());

        // apply, commit 을 안하면 변경된 내용이 저장되지 않음
        editor.apply();
    }
    // 설정값을 불러오는 함수
    private void load() {
        // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
        // 저장된 이름이 존재하지 않을 시 기본값
        saveLoginData = appData.getBoolean("SAVE_LOGIN_DATA", false);
        id = appData.getString("ID", "");

        //체크박스가 체크되었던 값으로 기억시 체크됨.
        if(saveLoginData){cbId.setChecked(true);}

        //처음로드시 값이 공백이면 무시 값이 있다면 아이디 가져와서 셋팅
        if(id.equals("")) {
        }
        else {
            etId.setText(id);
        }
    }
    //버튼이벤트를 감지함...
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnLogin: dataTest1();
                    break;

            }
        }
    };
    void dataTest1()
    {
        String id = etId.getText().toString();
        String pw = etPw.getText().toString();
        Toast.makeText(Ex1LoginActivity.this,
                "아이디:"+id+" / 비번:"+pw,
                Toast.LENGTH_SHORT).show();
    }
    void dataTest2()
    {
//        String id = etId.getText().toString();
//        String pw = etPw.getText().toString();
//        Log.d("로그인화면","아이디:"+id+" / 비번:"+pw);

        Intent intent1 =
                new Intent(Ex1LoginActivity.this, Ex1JoinActivity.class);
        startActivity(intent1);
    }


}