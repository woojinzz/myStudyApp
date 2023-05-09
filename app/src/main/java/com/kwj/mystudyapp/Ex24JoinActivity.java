package com.kwj.mystudyapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class Ex24JoinActivity extends AppCompatActivity {

    MySQLiteOpenHelper helper;

    String id,pw,name,hp,addr; //입력값을 변수에 저장해서 insert처리할변수
    EditText etId, etPw,etName,etHp,etAddr;
    Button btnCheck, btnJoin;
    Switch switchView;
    TextView tvSex,tvAreaText;
    Spinner spArea;

    String[] items = {"대전","대구","부산","서울","인천","광주"};
    String temp = "";//스피너 선택값 저장변수
    String sendAddr = "서울";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex24_join);


        //데이베이스 생성.
        helper = new MySQLiteOpenHelper(
                Ex24JoinActivity.this, // 현재 화면의 context
                "member.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호


        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);
        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);
        etAddr = (EditText) findViewById(R.id.etAddr);

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
                    //공백체크
                    if(etId.getText().toString().equals(""))
                    {
                        Toast.makeText(Ex24JoinActivity.this," 아이디를 입력해주세요!.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백 아니면 변수에 값 저장
                    id = etId.getText().toString();
                    //공백체크
                    if(etPw.getText().toString().equals(""))
                    {
                        Toast.makeText(Ex24JoinActivity.this," 비밀번호를 입력해주세요!.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백 아니면 변수에 값 저장
                    pw = etPw.getText().toString();
                    //공백체크
                    if(etName.getText().toString().equals(""))
                    {
                        Toast.makeText(Ex24JoinActivity.this," 이름을 입력해주세요!.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백 아니면 변수에 값 저장
                    name = etName.getText().toString();
                    //공백체크
                    if(etHp.getText().toString().equals(""))
                    {
                        Toast.makeText(Ex24JoinActivity.this," 번호를 입력해주세요!.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백 아니면 변수에 값 저장
                    hp = etHp.getText().toString();
                    //공백체크
                    if(etAddr.getText().toString().equals(""))
                    {
                        Toast.makeText(Ex24JoinActivity.this," 지역을 입력해주세요!.",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백 아니면 변수에 값 저장
                    id = etAddr.getText().toString();

                    insert(id,pw,name,hp,addr);
                    Toast.makeText(Ex24JoinActivity.this,"저장되었습니다.",Toast.LENGTH_SHORT).show();

                    Intent intent1 = new Intent(Ex24JoinActivity.this, JoinActivity.class);
                    intent1.putExtra("id",id);
                    intent1.putExtra("pw",pw);
                    intent1.putExtra("name",name);
                    intent1.putExtra("hp",hp);
                    intent1.putExtra("area",sendAddr);
                    startActivity(intent1);
                    break;
            }
        }
    };

    //데이타베이스 메서드 처리  ////////////////////////////
    public void insert(String id, String pw, String name, String hp, String addr) {

        SQLiteDatabase db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능

        //값들을 컨트롤 하려고 클래스 생성
        ContentValues values = new ContentValues();

        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
        // 데이터의 삽입은 put을 이용한다.
        values.put("id", id);
        values.put("pw", pw);
        values.put("name", name);
        values.put("hp", hp);
        values.put("addr", addr);
        db.insert("member", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)

        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
        db.close();
        Toast.makeText(getApplicationContext(), id+"로 회원 가입 완료.", Toast.LENGTH_LONG).show();

    }

}