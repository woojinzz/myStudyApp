package com.kwj.mystudyapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Ex32webMain extends AppCompatActivity {

    LinearLayout frame_member_list, frame_member_edit, frame_member_del;
    ////////////////////회원목록
    static ArrayList<Ex32ItemData> dataList = new ArrayList<>();
    static Ex32WebMainAdapter adapter = new Ex32WebMainAdapter(dataList);
    static RecyclerView recyclerView;

    int MAX = 100;
    //회원 리스트 배열선언
    String id[] = new String[MAX];
    String name[] = new String[MAX];
    String hp[] = new String[MAX];

    EditText etEditId, etEditName, etEditHp;//수정
    EditText etDelId;//삭제

    TextView tvDelName, tvDelHp, tvTitle;//삭제

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex32_web_main);

        frame_member_list = (LinearLayout)findViewById(R.id.frame_member_list);
        frame_member_edit = (LinearLayout) findViewById(R.id.frame_member_edit);
        frame_member_del = (LinearLayout) findViewById(R.id.frame_member_del);

        //회원목록
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);   // 리사이클러뷰 받아오기
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //회원수정
        etEditId = (EditText) findViewById(R.id.etEditId);
        etEditName = (EditText) findViewById(R.id.etEditName);
        etEditHp = (EditText) findViewById(R.id.etEditHp);

        //회원삭제
        etDelId = (EditText) findViewById(R.id.etDelId);
        tvDelName = (TextView) findViewById(R.id.tvDelName);
        tvDelHp = (TextView) findViewById(R.id.tvDelHp);

        tvTitle = (TextView) findViewById(R.id.tvTitle);

        //클릭리스너
        findViewById(R.id.menu1).setOnClickListener(mClickListener);
        findViewById(R.id.menu2).setOnClickListener(mClickListener);
        findViewById(R.id.menu3).setOnClickListener(mClickListener);
        findViewById(R.id.menu4).setOnClickListener(mClickListener);
        //수정
        findViewById(R.id.btnEditFind).setOnClickListener(mClickListener);
        findViewById(R.id.btnEdit).setOnClickListener(mClickListener);
        //삭제
        findViewById(R.id.btnDelFind).setOnClickListener(mClickListener);
        findViewById(R.id.btnDel).setOnClickListener(mClickListener);

        //초기화면값
        //웹통신해서 테이블값 가져오기...
        dataLoad();
    }

    void dataLoad(){

        //데이터 지우고
        dataList.clear();
        //아뎁터 변경내용 적용
        adapter.notifyDataSetChanged();

        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                try {
                    //333333333333333333333
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jArr = jsonObject.getJSONArray("member");
                    for(int i = 0; i < jArr.length(); i++) {
                        JSONObject info = jArr.getJSONObject(i);
                        id[i] = info.getString("id");
                        name[i] = info.getString("name");
                        hp[i] = info.getString("hp");
                        //어뎁터에 하나씩 추가
                        dataList.add(new Ex32ItemData(id[i], name[i], hp[i]));
                    }
                    //리사이클뷰에 최종추가
                    recyclerView.setAdapter(adapter); // 어댑터 설정

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        // 순서 여기 먼저 옴 11111111111111
        Ex32ServerRequestMember getUserCharLevelStat = new Ex32ServerRequestMember(responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(getUserCharLevelStat);
    }

    void editFind(String findId){

        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                try {

                    //333333333333333333333
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");


                    if(success){
                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String hp = jsonObject.getString("hp");
                        etEditId.setText(id);
                        etEditName.setText(name);
                        etEditHp.setText(hp);
                    } else {
                        Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                        Log.d("회원수정","아이디가 존재하지않습니다.");
                        etEditId.setText("");
                        etEditName.setText("");
                        etEditHp.setText("");
                    }

                } catch (JSONException e) {
                    Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                    Log.d("회원수정","문제생김. 에러내용:"+ e.getMessage());
                    e.printStackTrace();
                }
            }
        };
        // 순서 여기 먼저 옴 11111111111111
        Ex32ServerRequestEditFind getUserCharLevelStat = new Ex32ServerRequestEditFind(findId,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(getUserCharLevelStat);

    }

    void delFind(String findId){

        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                try {

                    //333333333333333333333
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");

                    if(success){
                      String name = jsonObject.getString("name");
                      String hp = jsonObject.getString("hp");

                      tvDelName.setText(name);
                      tvDelHp.setText(hp);

                    } else {
                        Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                        Log.d("회원삭제","아이디가 존재하지않습니다.");
                    }

                } catch (JSONException e) {
                    Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                    Log.d("회원삭제","문제생김. 에러내용:"+ e.getMessage());
                    e.printStackTrace();
                }
            }
        };

        // 순서 여기 먼저 옴 11111111111111
        Ex32ServerRequestEditFind getUserCharLevelStat = new Ex32ServerRequestEditFind(findId,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(getUserCharLevelStat);

    }

    void edit(){

        String editId = etEditId.getText().toString();
        String editName = etEditName.getText().toString();
        String editHp = etEditHp.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                try {

                    //333333333333333333333
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");
                    String hp = jsonObject.getString("hp");

                    if(success){
                        etEditId.setText(id);
                        etEditName.setText(name);
                        etEditHp.setText(hp);
                    } else {
                        Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                        Log.d("회원수정","아이디가 존재하지않습니다.");
                    }

                } catch (JSONException e) {
                    Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                    Log.d("회원수정","문제생김. 에러내용:"+ e.getMessage());
                    e.printStackTrace();
                }
            }
        };
        // 순서 여기 먼저 옴 11111111111111
        Ex32ServerRequestEdit getUserCharLevelStat = new Ex32ServerRequestEdit(editId,editName,editHp,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(getUserCharLevelStat);
    }

    void del(){

        String delId = etDelId.getText().toString();

        if(delId.equals("") ){
            Toast.makeText(context,"아이디를 입력하세요.",Toast.LENGTH_SHORT).show();
             return;

        }

        Response.Listener<String> responseListener = new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                try {

                    //333333333333333333333
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");

                    if(success){
                        Log.d("회원삭제","삭제가 완료되었습니다.");

                        etDelId.setText("");
                        tvDelName.setText("");
                        tvDelHp.setText("");
                    } else {
                        Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                        Log.d("회원삭제","아이디가 존재하지않습니다.");
                    }

                } catch (JSONException e) {
                    Toast.makeText(context,"아이디가 존재하지않습니다.",Toast.LENGTH_SHORT).show();
                    Log.d("회원삭제","문제생김. 에러내용:"+ e.getMessage());
                    e.printStackTrace();
                }
            }
        };
        // 순서 여기 먼저 옴 11111111111111
        Ex32ServerRequestDel getUserCharLevelStat = new Ex32ServerRequestDel(delId, responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(getUserCharLevelStat);
    }
    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {

            frame_member_list.setVisibility(View.INVISIBLE);
            frame_member_edit.setVisibility(View.INVISIBLE);
            frame_member_del.setVisibility(View.INVISIBLE);

            switch (v.getId()) {
                case R.id.menu1:
                    tvTitle.setText("회원목록");
                    frame_member_list.setVisibility(View.VISIBLE);
                    dataLoad();
                    break;
                case R.id.menu2 :
                    tvTitle.setText("회원정보 수정");
                    frame_member_edit.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnEditFind :
                    tvTitle.setText("회원정보 수정");
                    frame_member_edit.setVisibility(View.VISIBLE);

                    String findId = etEditId.getText().toString();
                    if(findId.equals(""))
                    {
                        Toast.makeText(context,"대상아이디를 입력하시오.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    editFind(findId);
                    break;
                case R.id.btnEdit :
                    tvTitle.setText("회원정보 수정");
                    frame_member_edit.setVisibility(View.VISIBLE);
                    edit();
                    break;

                case R.id.menu3 :
                    tvTitle.setText("회원정보 삭제");
                    frame_member_del.setVisibility(View.VISIBLE);
                    break;

                case R.id.btnDelFind :
                    tvTitle.setText("회원정보 삭제");
                    frame_member_del.setVisibility(View.VISIBLE);
                    String findDelId = etDelId.getText().toString();
                    if(findDelId.equals(""))
                    {
                        Toast.makeText(context,"대상아이디를 입력하시오.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    delFind(findDelId);

                    break;
                case R.id.btnDel :
                    tvTitle.setText("회원정보 삭제");
                    frame_member_del.setVisibility(View.VISIBLE);
                    del();
                    break;

                case R.id.menu4 :
                    break;
            }
        }
    };

    void dlgShow()
    {
        Dialog dlgFinish = new Dialog(Ex32webMain.this);
        dlgFinish.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlgFinish.setContentView(R.layout.dlg_layout);

        dlgFinish.show();

        Button noBtn = dlgFinish.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlgFinish.dismiss();
            }
        });
        dlgFinish.findViewById(R.id.yesBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
