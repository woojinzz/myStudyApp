package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Ex20FriendsListActivity extends AppCompatActivity {
    static ListView listView=null;
    static Ex20ListViewFriednsAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex20_friends_list);
        //id연동
        listView = (ListView)findViewById(R.id.listView);

        //버튼 이벤트처리
        findViewById(R.id.btnAdd).setOnClickListener(mClick);
        findViewById(R.id.btnEdit).setOnClickListener(mClick);
        findViewById(R.id.btnDel).setOnClickListener(mClick);
        findViewById(R.id.btnSearch).setOnClickListener(mClick);


        adapter  = new Ex20ListViewFriednsAdapter();
        adapter.addItem(new Ex20FriendsItem("woojin","010123123","남자","대전",22));
        adapter.addItem(new Ex20FriendsItem("qkqh","0102222222","여자","서울",32));
        adapter.addItem(new Ex20FriendsItem("dnwls","0103333333","남자","부산",42));

        //초기화면처리 리스트뷰...
        listView.setAdapter(adapter);
    }

    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnAdd:
                    Intent intentAdd = new Intent(Ex20FriendsListActivity.this, Ex20FriendAddActivity.class);
                    startActivity(intentAdd);
                    break;
                case R.id.btnEdit:
                    Intent intentEdit = new Intent(Ex20FriendsListActivity.this, Ex20FriendEditActivity.class);
                    startActivity(intentEdit);
                    break;
                case R.id.btnDel:
                    break;
                case R.id.btnSearch:
                    break;

            }

        }
    };

    static void setData(String name, String hp , String addr, String sex, int age)
    {
        adapter.addItem(new Ex20FriendsItem(name,hp,sex,addr,age));
        listView.setAdapter(adapter);

    }
}