package com.kwj.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Ex24MemberListActivity extends AppCompatActivity {

    LinearLayout frame1,frame2,frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex24_member_list);

        findViewById(R.id.btnList).setOnClickListener(mClick);
        findViewById(R.id.btnEdit).setOnClickListener(mClick);
        findViewById(R.id.btnDel).setOnClickListener(mClick);

        frame1 = (LinearLayout)findViewById(R.id.fame1);
        frame2 = (LinearLayout)findViewById(R.id.fame2);
        frame3 = (LinearLayout)findViewById(R.id.fame3);


    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            frame1.setVisibility(View.INVISIBLE);
            frame2.setVisibility(View.INVISIBLE);
            frame3.setVisibility(View.INVISIBLE);

            switch(v.getId())
            {
                case R.id.btnList:
                    frame1.setVisibility(View.VISIBLE);
                    Toast.makeText(Ex24MemberListActivity.this,"화면1",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnEdit:
                    frame2.setVisibility(View.VISIBLE);
                    Toast.makeText(Ex24MemberListActivity.this,"화면2",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnDel:
                    frame3.setVisibility(View.VISIBLE);
                    Toast.makeText(Ex24MemberListActivity.this,"화면3",Toast.LENGTH_SHORT).show();
                    break;

            }

        }
    };
}